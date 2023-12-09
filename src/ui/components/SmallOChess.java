package ui.components;

import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

public class SmallOChess extends SVGViewBase {
    protected void init(){
        this.content = new String[]{
                "M 232.5,-0.5 C 247.833,-0.5 263.167,-0.5 278.5,-0.5C 378.271,12.4486 449.438,64.4486 492,155.5C 502.136,180.379 508.636,206.046 511.5,232.5C 511.5,247.833 511.5,263.167 511.5,278.5C 505.761,334.801 484.094,383.968 446.5,426C 438.331,427.82 434.498,424.653 435,416.5C 495.76,342.684 510.76,260.351 480,169.5C 446.681,90.186 388.181,40.3526 304.5,20C 210.818,4.002 132.651,31.502 70,102.5C 11.4918,178.726 -0.174848,261.726 35,351.5C 69.8311,425.348 126.998,471.848 206.5,491C 286.314,505.467 356.647,486.134 417.5,433C 428.16,431.154 431.66,435.32 428,445.5C 385.05,483.72 334.884,505.72 277.5,511.5C 262.5,511.5 247.5,511.5 232.5,511.5C 132.727,498.549 61.5605,446.549 19,355.5C 8.86392,330.621 2.36392,304.954 -0.5,278.5C -0.5,263.167 -0.5,247.833 -0.5,232.5C 12.4486,132.729 64.4486,61.5622 155.5,19C 180.379,8.86392 206.046,2.36392 232.5,-0.5 Z M 227.5,113.5 C 236.857,111.848 244.524,114.682 250.5,122C 256.832,124.68 261.832,123.013 265.5,117C 273.5,112.333 281.5,112.333 289.5,117C 298.357,125.929 309.023,131.429 321.5,133.5C 312.856,154.655 297.522,162.155 275.5,156C 269.923,153.416 265.257,149.749 261.5,145C 254.725,141.589 249.392,143.256 245.5,150C 227.058,162.783 210.224,160.95 195,144.5C 192.639,141.112 190.806,137.446 189.5,133.5C 197.663,132.041 205.33,129.208 212.5,125C 217.116,120.537 222.116,116.703 227.5,113.5 Z",
                "M 171.5,85.5 C 179.725,86.6806 183.058,91.5139 181.5,100C 182.825,111.355 178.158,115.355 167.5,112C 166.874,111.25 166.374,110.416 166,109.5C 165.333,102.833 165.333,96.1667 166,89.5C 167.5,87.5313 169.333,86.198 171.5,85.5 Z",
                "M 336.5,85.5 C 339.939,85.5887 342.772,86.9221 345,89.5C 345.667,96.1667 345.667,102.833 345,109.5C 343.607,112.366 341.274,113.699 338,113.5C 335.186,113.592 332.853,112.592 331,110.5C 329,103.5 329,96.5 331,89.5C 332.5,87.5313 334.333,86.198 336.5,85.5 Z",
                "M 225.5,97.5 C 236.27,96.0449 246.27,98.0449 255.5,103.5C 268.052,96.5162 281.052,95.6829 294.5,101C 300.614,106.445 307.28,111.112 314.5,115C 338.726,117.12 344.392,128.787 331.5,150C 372.177,181.541 389.677,223.041 384,274.5C 376.014,320.316 351.18,353.483 309.5,374C 249.928,396.689 198.428,384.856 155,338.5C 122.8,295.526 117.134,249.193 138,199.5C 145.01,193.404 150.177,194.737 153.5,203.5C 131.121,256.776 140.788,303.276 182.5,343C 228.546,376.785 275.546,378.118 323.5,347C 361.476,315.743 375.643,275.91 366,227.5C 358.668,200.497 343.668,178.83 321,162.5C 305.502,174.997 288.336,177.831 269.5,171C 264.334,168.92 259.667,166.087 255.5,162.5C 239.789,174.941 222.456,177.774 203.5,171C 198.41,169.042 193.91,166.208 190,162.5C 181.233,169.263 173.067,176.763 165.5,185C 161.001,187.367 157.168,186.533 154,182.5C 153.183,179.036 153.517,175.702 155,172.5C 162.567,164.263 170.733,156.763 179.5,150C 172.779,140.513 171.945,130.68 177,120.5C 178.935,118.898 181.101,117.731 183.5,117C 191.632,117.045 198.965,114.711 205.5,110C 211.165,104.013 217.831,99.846 225.5,97.5 Z M 227.5,113.5 C 222.116,116.703 217.116,120.537 212.5,125C 205.33,129.208 197.663,132.041 189.5,133.5C 190.806,137.446 192.639,141.112 195,144.5C 210.224,160.95 227.058,162.783 245.5,150C 249.392,143.256 254.725,141.589 261.5,145C 265.257,149.749 269.923,153.416 275.5,156C 297.522,162.155 312.856,154.655 321.5,133.5C 309.023,131.429 298.357,125.929 289.5,117C 281.5,112.333 273.5,112.333 265.5,117C 261.832,123.013 256.832,124.68 250.5,122C 244.524,114.682 236.857,111.848 227.5,113.5 Z"
        };

        this.color = new String[]{
                "#000000",
                "#000000",
                "#000000",
                "#000000",
        };

        this.opacity = new Double[]{
                1.0,
                1.0,
                1.0,
                1.0
        };


        this.svgPath = new SVGPath[content.length];

        for (int i = 0; i < content.length; i++) {
            svgPath[i] = new SVGPath();
            svgPath[i].setContent(content[i]);
            svgPath[i].setFill(Color.web(color[i]));
            svgPath[i].setOpacity(opacity[i]);
        }

        this.getChildren().addAll(this.svgPath);
    }

    public SmallOChess(double w, double h){
        super(w, h);
    }

    public SmallOChess(double v){
        super(v);
    }

    public SmallOChess(){
        super();
    }


}
