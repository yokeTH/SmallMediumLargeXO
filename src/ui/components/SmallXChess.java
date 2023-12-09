package ui.components;

import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

public class SmallXChess extends SVGViewBase {
    protected void init(){
        this.content = new String[]{
                "M 285.5,-0.5 C 295.167,-0.5 304.833,-0.5 314.5,-0.5C 347.777,4.88836 376.61,19.2217 401,42.5C 404.069,52.1016 400.569,56.2683 390.5,55C 364.922,30.187 334.255,16.687 298.5,14.5C 267.531,18.0034 245.365,33.67 232,61.5C 282.419,50.2306 327.586,60.8972 367.5,93.5C 367.833,93.3333 368.167,93.1667 368.5,93C 363.762,80.6883 357.595,69.1883 350,58.5C 349.139,52.3508 351.805,48.6842 358,47.5C 360.316,47.9344 362.316,48.9344 364,50.5C 374.406,65.6454 382.406,81.9788 388,99.5C 396.458,93.0226 405.958,88.856 416.5,87C 412.252,81.9946 408.919,76.4946 406.5,70.5C 407.511,63.3343 411.511,60.8343 418.5,63C 425.156,70.6405 430.823,78.9738 435.5,88C 465.303,98.1665 478.47,119 475,150.5C 469.304,174.196 454.47,188.362 430.5,193C 422.09,193.549 413.757,193.216 405.5,192C 395.947,207.708 381.947,215.541 363.5,215.5C 356.984,215.445 350.651,214.612 344.5,213C 323.167,244.667 301.833,276.333 280.5,308C 301.667,339.833 322.833,371.667 344,403.5C 361.93,439.419 356.097,470.919 326.5,498C 317.037,504.737 306.704,509.237 295.5,511.5C 287.5,511.5 279.5,511.5 271.5,511.5C 252.311,507.819 236.811,498.152 225,482.5C 215.248,467.328 205.248,452.328 195,437.5C 182.869,455.596 170.369,473.429 157.5,491C 146.165,501.834 132.832,508.667 117.5,511.5C 109.5,511.5 101.5,511.5 93.5,511.5C 62.1044,503.936 42.9378,484.269 36,452.5C 33.8832,437.556 35.8832,423.223 42,409.5C 49.3333,398.167 56.6667,386.833 64,375.5C 68.6471,369.368 73.6471,369.035 79,374.5C 79.6667,377.167 79.6667,379.833 79,382.5C 70.5001,394.829 62.5001,407.496 55,420.5C 46.976,445.239 52.476,466.406 71.5,484C 100.722,502.59 127.222,499.09 151,473.5C 162.085,456.328 173.419,439.328 185,422.5C 186.105,418.877 187.105,415.21 188,411.5C 193.033,407.221 197.7,407.554 202,412.5C 202.333,415.167 202.667,417.833 203,420.5C 215.333,438.833 227.667,457.167 240,475.5C 258.675,495.376 280.842,500.543 306.5,491C 334.509,474.472 343.676,450.639 334,419.5C 312.393,385.563 290.393,351.897 268,318.5C 265.325,316.946 262.492,315.613 259.5,314.5C 254.631,305.969 257.131,300.969 267,299.5C 288,267.833 309,236.167 330,204.5C 330.667,203.5 330.667,202.5 330,201.5C 323.835,195.183 319.169,187.849 316,179.5C 298.076,154.971 274.576,147.471 245.5,157C 239.804,157.17 234.138,157.67 228.5,158.5C 220.196,171.303 211.696,183.97 203,196.5C 202.867,207.573 198.034,210.573 188.5,205.5C 186.978,202.36 186.145,199.027 186,195.5C 174.419,178.672 163.085,161.672 152,144.5C 134.188,122.086 111.688,115.586 84.5,125C 56.7927,139.922 46.626,162.755 54,193.5C 55.8061,198.446 58.1394,203.112 61,207.5C 81.6961,238.031 102.196,268.697 122.5,299.5C 131.434,300.582 134.268,305.249 131,313.5C 127.47,315.258 124.137,317.258 121,319.5C 112.225,333.274 103.058,346.774 93.5,360C 84.4201,363.215 80.2534,360.048 81,350.5C 90.5466,336.572 99.7132,322.405 108.5,308C 87.4634,276.097 66.2968,244.264 45,212.5C 33.8963,191.127 32.5629,169.127 41,146.5C 58.2918,114.27 85.1252,100.77 121.5,106C 137.569,109.95 151.069,118.117 162,130.5C 173,146.833 184,163.167 195,179.5C 200.795,170.074 206.962,160.908 213.5,152C 194.83,140.827 186.664,124.327 189,102.5C 191.211,88.4019 198.211,77.4019 210,69.5C 222.626,32.3657 247.792,9.03232 285.5,-0.5 Z M 262.5,72.5 C 312.36,72.5122 351.86,92.5122 381,132.5C 386.721,141.276 391.388,150.609 395,160.5C 397.438,178.128 390.605,190.628 374.5,198C 359.756,202.196 347.589,198.362 338,186.5C 325.27,155.117 301.936,138.451 268,136.5C 259.641,136.982 251.474,138.482 243.5,141C 223.449,143.268 210.616,134.768 205,115.5C 203.183,98.6302 210.016,86.7968 225.5,80C 237.674,75.9989 250.007,73.4989 262.5,72.5 Z M 421.5,102.5 C 452.127,106.966 463.961,124.299 457,154.5C 447.553,173.39 432.553,180.39 412,175.5C 412.261,166.238 410.928,157.238 408,148.5C 403.636,138.264 398.136,128.764 391.5,120C 398.989,109.641 408.989,103.808 421.5,102.5 Z",
                "M 146.5,227.5 C 154.131,229.234 157.131,234.067 155.5,242C 156.651,253.872 151.818,257.705 141,253.5C 139.409,246.608 139.076,239.608 140,232.5C 141.563,229.977 143.73,228.31 146.5,227.5 Z",
                "M 241.5,227.5 C 248.975,229.089 251.975,233.755 250.5,241.5C 251.882,253.643 247.049,257.643 236,253.5C 234.409,246.608 234.076,239.608 235,232.5C 236.272,229.508 238.438,227.841 241.5,227.5 Z",
                "M 179.5,240.5 C 181.527,240.338 183.527,240.505 185.5,241C 188.18,243.681 191.346,245.514 195,246.5C 198.56,245.305 201.726,243.471 204.5,241C 212.125,239.626 215.625,242.792 215,250.5C 210.621,258.448 203.788,262.448 194.5,262.5C 186.56,261.947 180.06,258.613 175,252.5C 173.309,247.131 174.809,243.131 179.5,240.5 Z"
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

        this.group.getChildren().addAll(this.svgPath);
    }

    public SmallXChess(double w, double h){
        super(w, h);
    }

    public SmallXChess(double v){
        super(v);
    }

    public SmallXChess(){
        super();
    }


}
