package Engine.AI;

class Cell implements Comparable<Cell>{
    public int x;
    public int y;
    public int G;
    public int H;
    public Cell parent;
    int value = 0;
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Cell o) {
        if(o == null) return -1;
        if (G + H > o.G + o.H)
            return 1;
        else if (G + H < o.G + o.H) return -1;
        return 0;
    }
}
