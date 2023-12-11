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
    protected  double componentW, componentH;

    protected abstract void init();
    protected Group group = new Group();

    private void setScale(){
        this.group.getTransforms().add(new Scale(scaleX, scaleY));
        if (componentW != 0){
            this.setMaxWidth(componentW);
            this.group.setTranslateX(componentW/2 - w/2);
        }else {
            this.setMaxWidth(w);
        }
        if (componentH != 0){
            this.setMaxHeight(componentH);
            this.group.setTranslateY(componentH/2 - h/2);
        }else {
            this.setMaxHeight(h);
        }

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

    public SVGViewBase(double v, double w, double h){
        this.w = v;
        this.h = v;
        componentW = w;
        componentH = h;
        this.scaleX = v/512;
        this.scaleY = v/512;
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
