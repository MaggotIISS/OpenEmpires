package fx.hexbutton;

import fx.hexbutton.util.CssHelper;
import fx.hexbutton.util.SkinPropertyBasedCssMetaData;
import java.util.List;
import javafx.animation.ScaleTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.SkinBase;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class HexButtonSkin extends SkinBase<HexButton> {

  private static class StyleableProperties {

    private static final SkinPropertyBasedCssMetaData<HexButton, Duration> SCALE_TRANSITION_TIME
      = CssHelper.createSkinMetaData("-fx-animation-duration",
        DurationStyleConverter.getInstance(), "scaleTransitionTime", Duration
        .millis(250));
    @SuppressWarnings("unchecked")
    private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES
      = CssHelper.createCssMetaDataList(HexButton.getClassCssMetaData(),
        SCALE_TRANSITION_TIME);

    private StyleableProperties() {
    }
  }

  protected HexButtonSkin(HexButton hexButton) {
    super(hexButton);
    hexButton.widthProperty().addListener(invalidHexListener);
    hexButton.heightProperty().addListener(invalidHexListener);
    hexButton.backgroundFillProperty().addListener(updateHexColorListener);
    hexButton.strokeFillProperty().addListener(updateHexColorListener);
    HexButton.armedProperty().addListener(updateEffectListener);
  }

  private Path hex;
  private boolean invalidHex = true;
  private final InvalidationListener invalidHexListener
    = (Observable observable) -> invalidHex = true;
  private ScaleTransition scaleTransition;
  private StyleableObjectProperty<Duration> scaleTransitionTime;
  private final InvalidationListener updateEffectListener = (
    Observable observable) -> updateEffect();
  private final InvalidationListener updateHexColorListener = (
    Observable observable) -> updateHexColor();

  @Override
  public void dispose() {
    if (scaleTransition != null) {
      scaleTransition.stop();
      scaleTransition = null;
    }

    getSkinnable().widthProperty().removeListener(invalidHexListener);
    getSkinnable().heightProperty().removeListener(invalidHexListener);
    getSkinnable().backgroundFillProperty().removeListener(
      updateHexColorListener);
    getSkinnable().strokeFillProperty().removeListener(updateHexColorListener);
    getSkinnable().armedProperty().removeListener(updateEffectListener);

    getChildren().clear();

    super.dispose();
  }

  @Override
  public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
    return StyleableProperties.STYLEABLES;
  }

  public Duration getScaleTransitionTime() {
    return scaleTransitionTime.get();
  }

  public void setScaleTransitionTime(Duration scaleTransitionTime) {
    this.scaleTransitionTime.set(scaleTransitionTime);
  }

  public StyleableObjectProperty<Duration> scaleTransitionTimeProperty() {
    if (scaleTransitionTime == null) {
      scaleTransitionTime = CssHelper.createProperty(
        StyleableProperties.SCALE_TRANSITION_TIME, HexButtonSkin.this);
    }
    return scaleTransitionTime;
  }

  public void updateHex(double height) {
    if (hex != null) {
      getChildren().remove(hex);
    }
    hex = new Path();
    double l3, l4, l5;
    l3 = height;
    l4 = l3 / 3 * 4;
    l5 = l3 / 3 * 5;
    hex.getElements().add(new MoveTo(0, l4));
    hex.getElements().add(new LineTo(l3, 0));
    hex.getElements().add(new LineTo(l3 + l5, 0));
    hex.getElements().add(new LineTo((l3 * 2) + l5, l4));
    hex.getElements().add(new LineTo(l3 + l5, l4 * 2));
    hex.getElements().add(new LineTo(l3, l4 * 2));
    hex.getElements().addAll(new ClosePath());
    updateHexColor();
    updateEffect();
    hex.setFill(getSkinnable().getBackgroundFill());
    hex.setStroke(getSkinnable().getStrokeFill());
    hex.setOnMouseEntered((MouseEvent e) -> zoomIn());
    hex.setOnMouseExited((MouseEvent e) -> zoomOut());
    hex.setOnMouseClicked((MouseEvent e) -> getSkinnable().fireEvent(
      new ActionEvent()));
    hex.setOnMousePressed((MouseEvent e) -> getSkinnable().setArmed(true));
    hex.setOnMouseReleased((MouseEvent e) -> getSkinnable().setArmed(false));
    getChildren().add(hex);
////////////////////////////////////////////////////////////////////////////////
//    if (hex != null) {
//      getChildren().remove(hex);
//    }
//    hex = new Path();
//    double l3, l4, l5;
//    l3 = height;
//    l4 = l3 / 3 * 4;
//    l5 = l3 / 3 * 5;
//    hex.getElements().add(new MoveTo(0, l3));
//    hex.getElements().add(new LineTo(l4, 0));
//    hex.getElements().add(new LineTo(l4 * 2, l3));
//    hex.getElements().add(new LineTo((l4 * 2), l3 + l5));
//    hex.getElements().add(new LineTo(l4, (l3 * 2) + l5));
//    hex.getElements().add(new LineTo(0, l5 + l3));
//    hex.getElements().addAll(new ClosePath());
//    updateHexColor();
//    updateEffect();
//    hex.setFill(getSkinnable().getBackgroundFill());
//    hex.setStroke(getSkinnable().getStrokeFill());
//    hex.setOnMouseEntered((MouseEvent e) -> zoomIn());
//    hex.setOnMouseExited((MouseEvent e) -> zoomOut());
//    hex.setOnMouseClicked((MouseEvent e) -> getSkinnable().fireEvent(new ActionEvent()));
//    hex.setOnMousePressed((MouseEvent e) -> getSkinnable().setArmed(true));
//    hex.setOnMouseReleased((MouseEvent e) -> getSkinnable().setArmed(false));
//    getChildren().add(hex);
  }

  public void updateHexColor() {
    if (hex != null) {
      hex.setFill(getSkinnable().getBackgroundFill());
      hex.setStroke(getSkinnable().getStrokeFill());
      getSkinnable().requestLayout();
    }
  }

  private void zoomIn() {
    if (scaleTransition != null) {
      scaleTransition.pause();
    }
    scaleTransition = new ScaleTransition(scaleTransitionTimeProperty().get(),
      hex);
    scaleTransition.setFromX(hex.getScaleX());
    scaleTransition.setFromY(hex.getScaleY());
    scaleTransition.setToX(3);
    scaleTransition.setToY(3);
    scaleTransition.play();
  }

  private void zoomOut() {
    if (scaleTransition != null) {
      scaleTransition.pause();
    }
    scaleTransition = new ScaleTransition(scaleTransitionTimeProperty().get(),
      hex);
    scaleTransition.setFromX(hex.getScaleX());
    scaleTransition.setFromY(hex.getScaleY());
    scaleTransition.setToX(1.0);
    scaleTransition.setToY(1.0);
    scaleTransition.play();
  }

  @Override
  protected double computeMaxHeight(double width, double topInset,
    double rightInset, double bottomInset, double leftInset) {
    return computePrefHeight(width, topInset, rightInset, bottomInset, leftInset);
  }

  @Override
  protected double computeMaxWidth(double height, double topInset,
    double rightInset, double bottomInset, double leftInset) {
    return computePrefWidth(height, topInset, rightInset, bottomInset, leftInset);
  }

  @Override
  protected double computeMinHeight(double width, double topInset,
    double rightInset, double bottomInset, double leftInset) {
    return 10 + topInset + bottomInset;
  }

  @Override
  protected double computeMinWidth(double height, double topInset,
    double rightInset, double bottomInset, double leftInset) {
    return 10 + rightInset + leftInset;
  }

  @Override
  protected double computePrefHeight(double width, double topInset,
    double rightInset, double bottomInset, double leftInset) {
    return topInset + bottomInset + 10;
  }

  @Override
  protected double computePrefWidth(double height, double topInset,
    double rightInset, double bottomInset, double leftInset) {
    return rightInset + leftInset + 10;
  }

  @Override
  protected void layoutChildren(double contentX, double contentY,
    double contentWidth, double contentHeight) {
    if (invalidHex) {
      updateHex(contentHeight);
      invalidHex = false;
    }
    layoutInArea(hex, contentX, contentY, contentWidth, contentHeight, -1,
      HPos.CENTER, VPos.CENTER);
  }

  protected void updateEffect() {
    if (getSkinnable().isArmed()) {
      if (hex != null) {
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(1.0f);
        innerShadow.setOffsetY(1.0f);
        hex.setEffect(innerShadow);
      }
    } else if (hex != null) {
      hex.setEffect(null);
    }
  }

}
