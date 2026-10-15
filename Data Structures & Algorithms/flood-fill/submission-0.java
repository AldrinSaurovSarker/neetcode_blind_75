class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];

        if (original != color)
            floodFill(image, sr, sc, color, original);
        
        return image;
    }

    public void floodFill(int[][] image, int x, int y, int color, int original) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != original) {
            return;
        }

        image[x][y] = color;

        floodFill(image, x + 1, y, color, original);
        floodFill(image, x - 1, y, color, original);
        floodFill(image, x, y + 1, color, original);
        floodFill(image, x, y - 1, color, original);
    }
}