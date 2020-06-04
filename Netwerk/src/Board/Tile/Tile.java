package Board.Tile;

import Pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileCoordinate;
    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles();

    // maakt een nieuwe tile aan op de aangegeven plek
    public static Tile createTile (int tileCoordinate, Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES.get(tileCoordinate);
    }

    public Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    //Maakt een lijst van alle vakken
    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for (int i = 0; i < 64; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }

        return emptyTileMap;
    }
}
