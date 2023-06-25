//1401. 圆和矩形是否有重叠
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        //判断圆心是否在绿色区域内
        if (isInRectangle(xCenter, yCenter, x1, y1, x2, y2)) return true;

        //判断圆心是否在蓝色区域内
        if (isInRectangle(xCenter, yCenter, x1 - radius, y1, x1, y2)) return true;
        if (isInRectangle(xCenter, yCenter, x1, y2, x2, y2 + radius)) return true;
        if (isInRectangle(xCenter, yCenter, x2, y1, x2 + radius, y2)) return true;
        if (isInRectangle(xCenter, yCenter, x1, y1 - radius, x2, y1)) return true;

        //判断圆心是否在红色区域内
        if (getDistSquare(xCenter, yCenter, x1, y2) <= radius*radius) return true;
        if (getDistSquare(xCenter, yCenter, x2, y2) <= radius*radius) return true;
        if (getDistSquare(xCenter, yCenter, x2, y1) <= radius*radius) return true;
        if (getDistSquare(xCenter, yCenter, x1, y1) <= radius*radius) return true;

        //不在任意区域，圆和矩形不重叠。
        return false;
    }
    public boolean isInRectangle(int xCenter, int yCenter, int x1, int y1, int x2, int y2){
        return xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2;
    }
    public int getDistSquare(int xCenter, int yCenter, int x, int y){
        return (xCenter-x)*(xCenter-x) + (yCenter-y)*(yCenter-y);
    }
}