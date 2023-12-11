package ui.components;

import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

public class LargeXChess extends SVGViewBase implements SetPrimaryColorAble, SetSecondColorAble{
    protected void init(){
        this.content = new String[]{
                "M 285.5,-0.5 C 295.167,-0.5 304.833,-0.5 314.5,-0.5C 347.777,4.88836 376.61,19.2217 401,42.5C 403.134,46.3529 402.967,50.0195 400.5,53.5C 397.988,54.9279 395.322,55.4279 392.5,55C 377.836,41.3269 361.169,30.6602 342.5,23C 337.293,20.9858 331.96,19.4858 326.5,18.5C 283.599,7.77961 251.599,21.9463 230.5,61C 237.829,60.3399 245.163,59.3399 252.5,58C 264.522,57.2751 276.522,57.4417 288.5,58.5C 318.741,63.3695 345.574,75.7029 369,95.5C 369.325,93.4473 368.991,91.4473 368,89.5C 363.095,78.6855 357.428,68.3521 351,58.5C 350.167,51.3333 353.333,48.1667 360.5,49C 361.931,49.4652 363.097,50.2986 364,51.5C 374.513,66.5263 382.346,82.8596 387.5,100.5C 396.238,93.9645 405.905,89.2978 416.5,86.5C 413.667,82.1667 410.833,77.8333 408,73.5C 407.157,69.8971 407.657,66.5637 409.5,63.5C 412.408,62.4309 415.408,62.2642 418.5,63C 425.156,70.6405 430.823,78.9738 435.5,88C 468.591,100.34 481.091,123.84 473,158.5C 465.125,177.695 450.958,189.195 430.5,193C 422.09,193.549 413.757,193.216 405.5,192C 395.947,207.708 381.947,215.541 363.5,215.5C 356.984,215.445 350.651,214.612 344.5,213C 323.167,244.667 301.833,276.333 280.5,308C 301.667,339.833 322.833,371.667 344,403.5C 361.93,439.419 356.097,470.919 326.5,498C 317.037,504.737 306.704,509.237 295.5,511.5C 287.5,511.5 279.5,511.5 271.5,511.5C 252.311,507.819 236.811,498.152 225,482.5C 215.248,467.328 205.248,452.328 195,437.5C 182.869,455.596 170.369,473.429 157.5,491C 146.165,501.834 132.832,508.667 117.5,511.5C 109.5,511.5 101.5,511.5 93.5,511.5C 62.1044,503.936 42.9378,484.269 36,452.5C 33.8832,437.556 35.8832,423.223 42,409.5C 49.5845,397.329 57.4178,385.329 65.5,373.5C 68.4566,370.642 71.7899,369.975 75.5,371.5C 78.3526,373.868 79.5193,376.868 79,380.5C 71,393.167 63,405.833 55,418.5C 45.7198,443.772 50.8864,465.606 70.5,484C 93.5579,500.313 116.891,500.646 140.5,485C 145.367,480.468 149.867,475.634 154,470.5C 164.667,454.5 175.333,438.5 186,422.5C 187.156,418.909 187.989,415.242 188.5,411.5C 198.196,407.331 203.029,410.664 203,421.5C 214.581,438.328 225.915,455.328 237,472.5C 259.656,499.163 286.156,503.663 316.5,486C 339.303,465.618 344.47,441.452 332,413.5C 310.667,381.5 289.333,349.5 268,317.5C 265.376,315.965 262.543,314.798 259.5,314C 255.706,305.431 258.539,300.597 268,299.5C 289.363,267.636 310.53,235.636 331.5,203.5C 329.902,200.399 327.735,197.732 325,195.5C 309.543,158.855 282.71,146.021 244.5,157C 238.804,157.17 233.138,157.67 227.5,158.5C 219.667,170.167 211.833,181.833 204,193.5C 203,197.167 202,200.833 201,204.5C 196.761,208.465 192.595,208.465 188.5,204.5C 187.759,201.587 187.259,198.587 187,195.5C 174.333,176.833 161.667,158.167 149,139.5C 132.904,122.597 113.404,116.764 90.5,122C 56.1653,136.506 44.3319,161.672 55,197.5C 76.6066,231.437 98.6066,265.103 121,298.5C 123.28,300.037 125.78,301.203 128.5,302C 133.268,305.706 133.601,309.706 129.5,314C 127.02,314.96 124.52,315.793 122,316.5C 112.538,331.26 102.705,345.76 92.5,360C 89.5184,360.498 86.5184,360.665 83.5,360.5C 80.8572,357.66 80.0239,354.327 81,350.5C 90.5466,336.572 99.7132,322.405 108.5,308C 87.4634,276.097 66.2968,244.264 45,212.5C 32.7038,188.679 32.3704,164.679 44,140.5C 63.4428,110.791 90.6095,99.6246 125.5,107C 140.023,111.193 152.19,119.027 162,130.5C 173,146.833 184,163.167 195,179.5C 200.795,170.074 206.962,160.908 213.5,152C 194.83,140.827 186.664,124.327 189,102.5C 191.211,88.4019 198.211,77.4019 210,69.5C 222.626,32.3657 247.792,9.03232 285.5,-0.5 Z",
                "M 326.5,18.5 C 311.665,28.5049 300.165,41.5049 292,57.5C 290.989,58.3366 289.822,58.67 288.5,58.5C 276.522,57.4417 264.522,57.2751 252.5,58C 245.163,59.3399 237.829,60.3399 230.5,61C 251.599,21.9463 283.599,7.77961 326.5,18.5 Z",
                "M 326.5,18.5 C 331.96,19.4858 337.293,20.9858 342.5,23C 361.169,30.6602 377.836,41.3269 392.5,55C 395.322,55.4279 397.988,54.9279 400.5,53.5C 404.212,56.2109 407.212,59.5442 409.5,63.5C 407.657,66.5637 407.157,69.8971 408,73.5C 410.833,77.8333 413.667,82.1667 416.5,86.5C 405.905,89.2978 396.238,93.9645 387.5,100.5C 382.346,82.8596 374.513,66.5263 364,51.5C 363.097,50.2986 361.931,49.4652 360.5,49C 353.333,48.1667 350.167,51.3333 351,58.5C 357.428,68.3521 363.095,78.6855 368,89.5C 368.991,91.4473 369.325,93.4473 369,95.5C 345.574,75.7029 318.741,63.3695 288.5,58.5C 289.822,58.67 290.989,58.3366 292,57.5C 300.165,41.5049 311.665,28.5049 326.5,18.5 Z",
                "M 284.5,73.5 C 282.408,73.5614 280.908,74.5614 280,76.5C 269.867,94.6377 268.867,113.304 277,132.5C 277.804,135.146 279.304,137.146 281.5,138.5C 274.523,137.543 267.523,137.377 260.5,138C 252.281,139.368 244.114,140.868 236,142.5C 215.878,140.378 205.378,129.211 204.5,109C 204.801,94.421 211.801,84.421 225.5,79C 244.905,72.7859 264.572,70.9525 284.5,73.5 Z",
                "M 284.5,73.5 C 328.048,79.3411 361.548,100.674 385,137.5C 388.861,143.888 392.194,150.554 395,157.5C 399.273,179.885 390.44,194.051 368.5,200C 355.498,201.417 344.998,196.917 337,186.5C 326.958,160.619 308.458,144.619 281.5,138.5C 279.304,137.146 277.804,135.146 277,132.5C 268.867,113.304 269.867,94.6377 280,76.5C 280.908,74.5614 282.408,73.5614 284.5,73.5 Z",
                "M 414.5,102.5 C 435.787,100.548 450.621,109.214 459,128.5C 463.137,146.43 457.97,160.93 443.5,172C 433.066,177.41 422.066,178.91 410.5,176.5C 412.383,161.763 409.217,148.096 401,135.5C 397.701,130.4 394.535,125.234 391.5,120C 393.393,116.101 396.059,112.768 399.5,110C 404.313,106.927 409.313,104.427 414.5,102.5 Z",
                "M 188.5,204.5 C 159.103,256.01 152.603,310.343 169,367.5C 173.645,383.112 180.145,397.778 188.5,411.5C 187.989,415.242 187.156,418.909 186,422.5C 175.333,438.5 164.667,454.5 154,470.5C 149.867,475.634 145.367,480.468 140.5,485C 116.891,500.646 93.5579,500.313 70.5,484C 50.8864,465.606 45.7198,443.772 55,418.5C 63,405.833 71,393.167 79,380.5C 79.5193,376.868 78.3526,373.868 75.5,371.5C 78.1667,367.833 80.8333,364.167 83.5,360.5C 86.5184,360.665 89.5184,360.498 92.5,360C 102.705,345.76 112.538,331.26 122,316.5C 124.52,315.793 127.02,314.96 129.5,314C 133.601,309.706 133.268,305.706 128.5,302C 125.78,301.203 123.28,300.037 121,298.5C 98.6066,265.103 76.6066,231.437 55,197.5C 44.3319,161.672 56.1653,136.506 90.5,122C 113.404,116.764 132.904,122.597 149,139.5C 161.667,158.167 174.333,176.833 187,195.5C 187.259,198.587 187.759,201.587 188.5,204.5 Z",
                "M 188.5,411.5 C 180.145,397.778 173.645,383.112 169,367.5C 152.603,310.343 159.103,256.01 188.5,204.5C 192.595,208.465 196.761,208.465 201,204.5C 202,200.833 203,197.167 204,193.5C 211.833,181.833 219.667,170.167 227.5,158.5C 233.138,157.67 238.804,157.17 244.5,157C 282.71,146.021 309.543,158.855 325,195.5C 327.735,197.732 329.902,200.399 331.5,203.5C 310.53,235.636 289.363,267.636 268,299.5C 258.539,300.597 255.706,305.431 259.5,314C 262.543,314.798 265.376,315.965 268,317.5C 289.333,349.5 310.667,381.5 332,413.5C 344.47,441.452 339.303,465.618 316.5,486C 286.156,503.663 259.656,499.163 237,472.5C 225.915,455.328 214.581,438.328 203,421.5C 203.029,410.664 198.196,407.331 188.5,411.5 Z",
                "M 154.5,251.5 C 145.464,258.151 140.464,255.817 139.5,244.5C 139.133,240.033 139.633,235.7 141,231.5C 145.625,227.354 149.959,227.687 154,232.5C 154.5,238.825 154.666,245.158 154.5,251.5 Z",
                "M 249.5,244.5 C 250.334,252.164 247,255.664 239.5,255C 237.676,254.34 236.343,253.173 235.5,251.5C 234.421,245.551 234.254,239.551 235,233.5C 239.171,227.271 243.837,226.938 249,232.5C 249.499,236.486 249.666,240.486 249.5,244.5 Z",
                "M 178.5,241.5 C 183.437,240.603 187.437,242.103 190.5,246C 195.748,247.476 200.081,246.143 203.5,242C 211.791,240.045 215.291,243.212 214,251.5C 207.589,259.974 199.089,263.14 188.5,261C 183.588,259.292 179.421,256.458 176,252.5C 173.584,248.078 174.417,244.411 178.5,241.5 Z",
                "M 139.5,244.5 C 140.464,255.817 145.464,258.151 154.5,251.5C 163.369,266.954 159.036,277.121 141.5,282C 130.302,284.599 120.802,281.765 113,273.5C 107.017,259.291 111.517,249.791 126.5,245C 130.821,244.501 135.154,244.334 139.5,244.5 Z",
                "M 249.5,244.5 C 262.57,242.62 272.403,247.287 279,258.5C 280.342,270.512 275.175,278.345 263.5,282C 251.622,284.89 241.455,282.057 233,273.5C 227.856,265.386 228.689,258.053 235.5,251.5C 236.343,253.173 237.676,254.34 239.5,255C 247,255.664 250.334,252.164 249.5,244.5 Z",
        };

        this.color = new String[]{
                "#010202",
                "#e75a6f",
                "#fc8c9c",
                "#d2d2fd",
                "#edebfd",
                "#d2d2fc",
                "#30cc9b",
                "#6fdbb9",
                "#050605",
                "#050505",
                "#020504",
                "#fd8e9d",
                "#fd8e9e"
        };

        this.opacity = new Double[]{
                0.967,
                1.0,
                0.998,
                1.0,
                1.0,
                1.0,
                1.0,
                1.0,
                1.0,
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

    public LargeXChess(double w, double h){
        super(w, h);
    }

    public LargeXChess(double v){
        super(v);
    }

    public LargeXChess(){
        super();
    }

    @Override
    public void setPrimaryColor(String color){
        svgPath[6].setFill(Color.web(color));
    }

    @Override
    public void setSecondColor(String color) {
        svgPath[7].setFill(Color.web(color));
    }
}