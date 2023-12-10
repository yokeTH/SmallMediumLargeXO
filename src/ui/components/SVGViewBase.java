package ui.components;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Scale;

abstract public class SVGViewBase extends Pane {

    protected SVGPath[] svgPath;
    protected String[] content;
    protected String[] color;
    protected Double[] opacity;

    protected double scaleX;
    protected double scaleY;
    protected double w,h;

    protected abstract void init();
    protected Group group = new Group();

    private void setScale(){
        this.group.getTransforms().add(new Scale(scaleX, scaleY));
        this.setMaxWidth(w);
        this.setMaxHeight(h);
        this.getChildren().addAll(this.group);
    }

    public SVGViewBase(double w, double h){
        this.w = w;
        this.h = h;
        this.scaleX = w/512;
        this.scaleY = h/512;
        setScale();
        init();
    }

    public SVGViewBase(double v){
        this.w = v;
        this.h = v;
        this.scaleX = v/512;
        this.scaleY = v/512;
        setScale();
        init();
    }

    public SVGViewBase(){
        this.w = 512;
        this.h = 512;
        this.scaleY = 1;
        this.scaleX = 1;
        init();
    }
}
