package application;
	


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane LayoutRoot = new BorderPane();
			Scene scene = new Scene(LayoutRoot,600,300);
			
			// Criar o menuBar e associar os menus  
			MenuBar menuBar = new MenuBar();						
			Menu menuAnimes = new Menu("_Animes");					
			Menu menuRed = new Menu("_Menu Red");				 
			Menu menuBlue = new Menu("_Menu Blue");
			
			
			// Menu Ficheiro - Opções simples
			RadioMenuItem menuItemFileAnime = new RadioMenuItem("Anime");	// Opções do menu filme
			RadioMenuItem menuItemFileSinopse = new RadioMenuItem("Anime e Sinopse");
			RadioMenuItem menuItemFileComentario = new RadioMenuItem("Anime, Sinopse e Comentários");
			RadioMenuItem menuItemFileLimpar = new RadioMenuItem("Limpar");
			
			//Menu items para adicionar ao menu red e blue
			MenuItem menuitem1 = new MenuItem("opçao 1");
			MenuItem menuitem2 = new MenuItem("opçao 2");
			MenuItem menuitem3 = new MenuItem("opçao 3");
			MenuItem menuitem4 = new MenuItem("opçao 4");
			
			menuRed.getItems().addAll(menuitem1,menuitem2);
			menuitem1.setOnAction(e->
				{
					Utils.alertBox("Menu 1","opção em desenvolvimento");
				}
			);
			menuitem2.setOnAction(e->
				{
					Utils.alertBox("Menu 2","opção em desenvolvimento");
				}
			);
			
			menuBlue.getItems().addAll(menuitem3,menuitem4);
			menuitem3.setOnAction(e->
				{
						Utils.alertBox("Menu 666","You have summoned satan");
						
				}
			);
			menuitem4.setOnAction(e->
				{
					Utils.alertBox("Menu 0","opção zero esta interdita a meros humanos");
				}
		    );
			//LayoutRoot.setCenter(null);
			
			//Agrupar os RadioMenuItens da MSG num Toggle
			ToggleGroup toggleMenuFileMsg = new ToggleGroup();
			menuItemFileAnime.setToggleGroup(toggleMenuFileMsg);
			menuItemFileSinopse.setToggleGroup(toggleMenuFileMsg);
			menuItemFileComentario.setToggleGroup(toggleMenuFileMsg);
			menuItemFileLimpar.setToggleGroup(toggleMenuFileMsg);
			menuItemFileAnime.setSelected(true);					// opção prédefinida (checked)
			
			menuAnimes.getItems().addAll(
					menuItemFileAnime,
					menuItemFileSinopse,
					menuItemFileComentario,
					menuItemFileLimpar);
			

			menuBar.getMenus().addAll(menuAnimes, menuRed, menuBlue);
			
			menuItemFileAnime.setOnAction(e->{
				
			
				TableView<Animes> listaAnime = new TableView<>();
				
				TableColumn<Animes,String> colunaNome= new TableColumn<>("Nome");
				colunaNome.setMinWidth(200);
				colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
				
				listaAnime.getColumns().add(colunaNome);
				listaAnime.setItems(carregalistaAnime());
				
				LayoutRoot.setCenter(listaAnime);
				
			});
			menuItemFileSinopse.setOnAction(e->{
				
				
				TableView<Animes> listaAnime = new TableView<>();
				
				TableColumn<Animes,String> colunaNome= new TableColumn<>("Nome");
				colunaNome.setMinWidth(200);
				colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
				
				TableColumn<Animes,String> colunaSinopse= new TableColumn<>("Sinopse");
				colunaSinopse.setMinWidth(200);
				colunaSinopse.setCellValueFactory(new PropertyValueFactory<>("Sinopse"));
				
				listaAnime.getColumns().addAll(colunaNome, colunaSinopse);
				listaAnime.setItems(carregalistaAnime2());
				
				LayoutRoot.setCenter(listaAnime);
			});
			menuItemFileComentario.setOnAction(e->{
				
				
				TableView<Animes> listaAnime = new TableView<>();
				
				TableColumn<Animes,String> colunaNome= new TableColumn<>("Nome");
				colunaNome.setMinWidth(200);
				colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
				
				TableColumn<Animes,String> colunaSinopse= new TableColumn<>("Sinopse");
				colunaSinopse.setMinWidth(200);
				colunaSinopse.setCellValueFactory(new PropertyValueFactory<>("Sinopse"));

				TableColumn<Animes,String> colunaComentario= new TableColumn<>("Comentario");
				colunaComentario.setMinWidth(200);
				colunaComentario.setCellValueFactory(new PropertyValueFactory<>("Comentario"));
				
				listaAnime.getColumns().addAll(colunaNome, colunaSinopse, colunaComentario );
				listaAnime.setItems(carregalistaAnime3());
				
				LayoutRoot.setCenter(listaAnime);
			});
			
			menuItemFileLimpar.setOnAction(e->{
				Utils.alertBox("Menu Limpar","Deixará de ver a tabela");
				
				LayoutRoot.setCenter(null);
				
			});
			
			// associar o menu à região TOP do rootLayout
			LayoutRoot.setTop(menuBar);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	private ObservableList<Animes> carregalistaAnime(){
		
		
		ObservableList<Animes> listaAnime = FXCollections.observableArrayList();
		
		listaAnime.add(new Animes("Tokyo Ghoul"));
		listaAnime.add(new Animes("Naruto"));
		listaAnime.add(new Animes("DragonBall"));
		listaAnime.add(new Animes("Mirai Nikki"));

	    
	    return listaAnime;
	}
	
	private ObservableList<Animes> carregalistaAnime2(){
		
		
		ObservableList<Animes> listaAnime = FXCollections.observableArrayList();
		
		listaAnime.add(new Animes("Tokyo Ghoul" , "Um rapaz que come pessoas"));
		listaAnime.add(new Animes("Naruto", "Um ninja e a sua vida"));
		listaAnime.add(new Animes("DragonBall", "Homens com muita força"));
		listaAnime.add(new Animes("Mirai Nikki", "Diários do futuro"));

	    
	    return listaAnime;
	}
	
	private ObservableList<Animes> carregalistaAnime3(){
		
		
		ObservableList<Animes> listaAnime = FXCollections.observableArrayList();
		
		listaAnime.add(new Animes("Tokyo Ghoul" ,"Um rapaz que come pessoas", "muito bom"));
		listaAnime.add(new Animes("Naruto", "Um ninja e a sua vida", "demasiado lamechas"));
		listaAnime.add(new Animes("DragonBall", "Homens com muita força", "mainstream"));
		listaAnime.add(new Animes("Mirai Nikki", "Diários do futuro", "muito sangue"));

	    
	    return listaAnime;
	}
}
