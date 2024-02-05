package edu.lab1.models;

/*
 *   plainText: helloworld**
 *   --> |hel|
 *   --> |low|
 *   --> |orl|
 *   --> |d**|
 */
public final class Table {
    private final int width;
    private final int height;
    private final int size;

    public Table(int width, int height) {
        checkWidth(width);
        checkHeight(height);

        this.width  = width;
        this.height = height;
        this.size   = width * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return size;
    }

    private static void checkWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be negative or zero.");
        }
    }

    private static void checkHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be negative or zero.");
        }
    }
}
