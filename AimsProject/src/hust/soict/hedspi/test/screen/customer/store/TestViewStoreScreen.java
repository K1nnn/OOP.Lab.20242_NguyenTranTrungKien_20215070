package hust.soict.hedspi.test.screen.customer.store;

import java.util.ArrayList;
import java.util.List;


import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	
	private static Store store;
	private static Cart cart;
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH= "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		initStore();
		ViewStoreController viewStoreController = new ViewStoreController(store,cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store=new Store();
		cart=new Cart();
		launch(args);
	}
	
	private void initStore() throws LimitExceedMediaException, ExistedMediaException{
		 DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
	     store.addMedia(dvd);
	     
	     // add cd
	     Track track1 = new Track("The Lion King", 87);
	     Track track2 = new Track("Battle", 32);
	     List<Track> tracks = new ArrayList<Track>();
	     tracks.add(track1);
	     tracks.add(track2);
	     CompactDisc cd = new CompactDisc("The Lion Prince", "Animation", 19.95f, "Roger Allers", tracks);
	     store.addMedia(cd);

	     // add book
	     List<String> authors = new ArrayList<String>();
	     authors.add("John Doe");
	     authors.add("Jane De");
	     Book book = new Book("Data Structures and Algorithms", "Computer Science", 100.0f, authors);
	     store.addMedia(book);
	     
	     // add dvd
	     DigitalVideoDisc dvd2 = new DigitalVideoDisc("Bayby Shark", "Cartoon", "Alibaba", 24, 9.25f);
	     store.addMedia(dvd2);
	}
}
