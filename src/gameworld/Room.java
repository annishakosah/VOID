package gameworld;

public class Room {
    private Tile[][] tiles;
    private final int ROOMSIZE = 10;


    public Room(){
        //may need to change this depending on XML
        this.tiles = new Tile[ROOMSIZE][ROOMSIZE];
        //For now until we can load in an XML file
        for(int i = 0; i < ROOMSIZE; i++){
            for(int j = 0; j < ROOMSIZE; j++){
                tiles[i][j] = new AccessibleTile(this);
            }
        }
        //Just to test if door checking works
        tiles[0][0] = new DoorTile(this, this);
    }

    public Tile moveTile(Tile t, int dx, int dy){
        int[] coords = getCoordsofTile(t);

        int x = coords[0];
        int y = coords[1];

        int newX = x+dx;
        int newY = y+dy;

        //if the newCoordinates are inbounds and the tile is not inaccessible
        if(newX<10 && newY<10 && newX >=0 && newY >=0 && !(tiles[newX][newY] instanceof InaccessibleTile)){
            return tiles[newX][newY];
        }

        return null;
    }

    public int[] getCoordsofTile(Tile t){

        for(int i=0; i<ROOMSIZE; i++){
            for(int j=0; j<ROOMSIZE; j++){

                //returns coordinates of the tile
                if(tiles[i][j].equals(t)) return new int[]{i,j};
            }
        }

        return null;
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

}
