package fx.hexbutton;

//import com.sun.javafx.css.converters.PaintConverter;
import dbviewer.globals.GlobalMethods;
import java.io.File;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.css.StyleableObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Skin;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import panels.Panel4T5Locator;

public final class HexButton extends Control {

  private Image image;
  private ImageView imageView;
  private Stage owner = new Stage();
  private Scene scene;
  private StackPane pane;
  private Label label = new Label(system);

  private static String start = "C://T5";
  private static String sec = "Spinward Marches";
  private static String sub = "C Regina";
  private static String system = "1705 Efate";
//  private String system = "1910 Regina";
  private static String FS = "/";
  private static File folder = new File(start + FS + sec + FS + sub + FS
    + system + FS + system);

  public static String[] names = {"gif", "txt", "html", "t5c"};
  public static int selnum = 2;
  private boolean OK = true;
  private int max = names.length;

//  public static void main(String[] args) throws Exception {
//    new ShowHexButton();
//  }
  public HexButton() {
    super();
    if (Panel4T5Locator.isRunning()) {
      hexChange();
    }
    setTooltip(new Tooltip(names[selnum].toUpperCase()));
    setId("Imperial");
    setPadding(new Insets(0));
//    String stylesheet = getClass().getResource("HexButtonStylesheet.css").toExternalForm();
//    getStylesheets().removeAll();
//    getStylesheets().add(stylesheet);
    setOnAction((ActionEvent e) -> {
      addContextMenu(names[selnum]);
      selnum += 1;
      if (selnum == max) {
        selnum = 0;
      }
      setTooltip(new Tooltip(names[selnum].toUpperCase()));
      skinChange();
    });
    armedProperty().addListener((observable, oldValue, newValue)
      -> pseudoClassStateChanged(ARMED_PSEUDO_CLASS, newValue));
    addContextMenu(names[selnum]);
//    setStyle("-fx-background-color: blue;");
//    setSkin(new HexButtonSkin(this));
  }

  public HexButton(String string) {
    this();
    setId(string);
  }

//  public HexButton(Stage stage) {
//    this();
//    owner=stage;
//    System.out.println("stage.toString()" + " = " + stage.toString());
//    System.out.println("this.stage.toString()" + " = " + this.owner.toString());
//  }
  private void skinChange() {
    if (OK) {
      setSkin(new HexButtonSkin(this));
    } else {
      setSkin(new HexButtonSkinUp(this));
    }
    OK = !OK;
  }

  @SuppressWarnings("unchecked")
  public void addContextMenu(String ext) {
    ContextMenu contextMenu;
    contextMenu = new ContextMenu();
    hexChange();
    MenuItem menuItem = new MenuItem(system);
    ObservableList<String> list = FXCollections.observableArrayList();
    hexChange();
    String[] all = folder.list();
    for (int i = 0; i < all.length; i++) {
      String string = all[i].substring(0, all[i].length() - (ext.length() + 1));
      if (all[i].toLowerCase().endsWith(ext)) {
        list.add(string);
        menuItem = new MenuItem(string);
        menuItem.addEventHandler(EventType.ROOT, new EventHandler() {
          @Override
          public void handle(Event event) {
            String filename = start + FS + sec + FS + sub + FS + system + FS
              + system + FS + string + "." + ext;
//            System.out.println(filename);
            if (new File(filename).exists()) {
//              System.out.println("Exists!");
              if ("gif".equals(ext.toLowerCase())) {
                showPic(filename);
              }
              if ("txt".equals(ext.toLowerCase())) {
                showTxt(filename);
              }
              if ("t5c".equals(ext.toLowerCase())) {
                showTxt(filename);
              }
              if ("html".equals(ext.toLowerCase())) {
                showWebPage(filename);
              }
            }
          }
        });
        contextMenu.getItems().add(menuItem);
      }
    }
    setContextMenu(contextMenu);
  }

  private void showPic(String filename) {
    System.out.println(filename);
    image = new Image("file:///" + filename);
    imageView = new ImageView(image);
    StackPane tran = new StackPane();
    tran.getChildren().add(imageView);
    Stage stage = new Stage();
//    this.stage.initOwner(stage);
    Scene transparent = new Scene(tran, image.getWidth(), image.getHeight());
    stage.setScene(transparent);
//    stage.initOwner();
    stage.initStyle(StageStyle.DECORATED);
    stage.setTitle(filename);
    stage.setX(0);
    stage.setY(0);
    stage.show();

    System.out.println("" + " = " + stage.getOwner());
  }

  private void showTxt(String filename) {
    if (image != null) {
      System.out.println(image.toString());
    }
    TextArea textArea = new TextArea(GlobalMethods.loadTextFile(filename));
    StackPane pane = new StackPane();
    pane.getChildren().add(textArea);

    Stage stage = new Stage();
    Scene scene = new Scene(pane);

    stage.setScene(scene);
//    this.stage.initOwner(stage);
    stage.initStyle(StageStyle.DECORATED);
    stage.setTitle(filename);
    stage.setX(0);
    stage.setY(0);
    stage.show();
  }

  private void showWebPage(String filename) {
    WebEngine webEngine = new WebEngine();
    WebView webView = new WebView();
    webView.getEngine().load("file:///" + filename);

    StackPane pane = new StackPane();
    pane.getChildren().add(webView);
    Scene scene = new Scene(pane);
    Stage stage = new Stage();
    stage.setScene(scene);
//    stage.initOwner(this.stage);
    stage.initStyle(StageStyle.DECORATED);
    stage.setTitle(filename);
    stage.setX(0);
    stage.setY(0);
    stage.show();

  }

  public static ContextMenu getMenuItems() {
    ContextMenu conmen = new ContextMenu();
    MenuItem menuItem = new MenuItem(null);
    ObservableList<String> list = FXCollections.observableArrayList();

    String[] all = folder.list();
    for (int i = 0; i < all.length; i++) {
      String it = all[i].substring(0, all[i].lastIndexOf("."));
      if (all[i].toLowerCase().endsWith("gif")) {
        list.add(it);
        menuItem = new MenuItem(it);
        conmen.getItems().add(menuItem);
      }
    }
    return conmen;
  }

  public static String[] getStrings(String ext) {
    MenuItem menuItem = new MenuItem(null);
    ObservableList<String> list = FXCollections.observableArrayList();
    String[] all = folder.list();
    for (int i = 0; i < all.length; i++) {
      String it = all[i].substring(0, all[i].length() - 4);
      if (all[i].toLowerCase().endsWith(ext)) {
        list.add(it);
        menuItem = new MenuItem(it);
      }
    }
    return all;
  }

  public static void hexChange() {
    try {
      sec = panels.Panel4T5Locator.jcb4Sec.getSelectedItem().toString();
      sub = panels.Panel4T5Locator.jcb4Sub.getSelectedItem().toString();
      system = panels.Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
        .trim();
      folder = new File(start + FS + sec + FS + sub + FS + system + FS + system);
    } catch (Exception e) {
      sec = "Spinward Marches";
      sub = "C Regina";
      system = "1705 Efate";
      folder = new File(start + FS + sec + FS + sub + FS + system + FS + system);
    }
    System.out.println(sec);
    System.out.println(sub);
    System.out.println(system);
    System.out.println(folder);
  }

  public ImageView getImageView() {
    return imageView;
  }

  public static ContextMenu getMenuItems(String EXT) {
    ContextMenu conmen = new ContextMenu();
    MenuItem menuItem = new MenuItem(null);
    ObservableList<String> list = FXCollections.observableArrayList();
    String[] all = folder.list();
    for (int i = 0; i < all.length; i++) {
      String it = all[i].substring(0, all[i].length() - (EXT.length() + 1));
      if (all[i].toLowerCase().endsWith(EXT)) {
        list.add(it);
        menuItem = new MenuItem(it);
        conmen.getItems().add(menuItem);
      }
    }

//    for (int i = 0; i < list.size(); i++) {
//      System.out.println(list.get(i));
//    }
    return conmen;
  }

  private StyleableObjectProperty<Paint> backgroundFill;

  public StyleableObjectProperty<Paint> backgroundFillProperty() {
    if (backgroundFill == null) {
//      backgroundFill = CssHelper.createProperty(
//        StyleableProperties.BACKGROUND_FILL, HexButton.this);
    }
    return backgroundFill;
  }

  public Paint getBackgroundFill() {
    return backgroundFill == null ? Color.DARKGRAY : backgroundFill.get();
  }

  public void setBackgroundFill(Paint backgroundFill) {
    this.backgroundFill.set(backgroundFill);
  }

  private StyleableObjectProperty<Paint> strokeFill;

  public StyleableObjectProperty<Paint> strokeFillProperty() {
    if (strokeFill == null) {
//      strokeFill = CssHelper.createProperty(StyleableProperties.STROKE_FILL,
//        HexButton.this);
    }
    return strokeFill;
  }

  public Paint getStrokeFill() {
    return strokeFill == null ? Color.DARKGRAY : strokeFill.get();
  }

  public void setStrokeFill(Paint strokeFill) {
    this.strokeFill.set(strokeFill);
  }

  private static final PseudoClass ARMED_PSEUDO_CLASS
    = PseudoClass.getPseudoClass("armed");

  private static BooleanProperty armed;

  public static BooleanProperty armedProperty() {
    if (armed == null) {
      armed = new SimpleBooleanProperty(false);
    }
    return armed;
  }

  public boolean isArmed() {
    return armed == null ? false : armed.get();
  }

  public void setArmed(boolean armed) {
    armedProperty().set(armed);
  }

  private final ObjectProperty<EventHandler<ActionEvent>> onAction
    = new ObjectPropertyBase<EventHandler<ActionEvent>>() {

    @Override
    public Object getBean() {
      return HexButton.this;
    }

    @Override
    public String getName() {
      return "onAction";
    }

    @Override
    protected void invalidated() {
      setEventHandler(ActionEvent.ACTION, get());
    }
  };

  public ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
    return onAction;
  }

  public EventHandler<ActionEvent> getOnAction() {
    return onActionProperty().get();
  }

  public void setOnAction(EventHandler<ActionEvent> value) {
    onActionProperty().set(value);
  }

  private static class StyleableProperties {

//    private static final DefaultPropertyBasedCssMetaData<HexButton, Paint> BACKGROUND_FILL
//      = CssHelper.createMetaData("-fx-hex-fill",
//        PaintConverter.getInstance(), "backgroundFill", Color.LIGHTGREEN);
//
//    private static final DefaultPropertyBasedCssMetaData<HexButton, Paint> STROKE_FILL
//      = CssHelper.createMetaData("-fx-hex-stroke",
//        PaintConverter.getInstance(), "strokeFill", Color.BLUE);
//
//    @SuppressWarnings("unchecked")
//    private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES
//      = createCssMetaDataList(Control.getClassCssMetaData(), BACKGROUND_FILL,
//        STROKE_FILL);
  }

//  public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
//    return StyleableProperties.STYLEABLES;
//  }
//  @Override
//  public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
//    return StyleableProperties.STYLEABLES;
//  }
  @Override
  protected Skin<?> createDefaultSkin() {
    return new HexButtonSkin(this);
//    return new HexButtonSkinUp(this);
  }

}
