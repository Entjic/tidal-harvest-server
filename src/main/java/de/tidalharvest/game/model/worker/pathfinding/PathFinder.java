package de.tidalharvest.game.model.worker.pathfinding;

import de.tidalharvest.game.model.board.Board;
import de.tidalharvest.game.model.board.FieldType;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PathFinder {

    public List<Coordinate> findPath(Coordinate start, Coordinate end, Board board) {
        List<List<Coordinate>> adj = adjList(board);
        return bfs(start, end, adj, board.getYSize());
    }

    private List<Coordinate> bfs(Coordinate start,
                                 Coordinate target,
                                 List<List<Coordinate>> adj,
                                 int yLimit) {

        // Edge case: start is the same as target
        if (start.equals(target)) return List.of(start);

        // Set to keep track of visited nodes
        Set<Coordinate> closed = new HashSet<>();
        closed.add(start);

        // Map to store predecessors for path reconstruction
        Map<Coordinate, Coordinate> predecessors = new HashMap<>();

        // Queue for BFS
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);

        // Perform BFS
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            // Get all adjacent nodes
            List<Coordinate> neighbors = adj.get(id(current, yLimit));
            for (Coordinate neighbor : neighbors) {
                if (!closed.contains(neighbor)) {
                    closed.add(neighbor);
                    predecessors.put(neighbor, current); // Record the predecessor
                    queue.add(neighbor);

                    // If the target is found, reconstruct the path
                    if (neighbor.equals(target)) {
                        return constructPath(predecessors, target);
                    }
                }
            }
        }

        // If the target is not reachable, return an empty list
        return List.of();
    }

    // Helper method to reconstruct the path from start to target using the predecessors map
    private List<Coordinate> constructPath(Map<Coordinate, Coordinate> predecessors,
                                           Coordinate target) {
        List<Coordinate> path = new ArrayList<>();
        for (Coordinate at = target; at != null; at = predecessors.get(at)) {
            path.add(at);
        }
        Collections.reverse(path); // The path is constructed in reverse order, so reverse it
        return path;
    }

    private int id(Coordinate c, int yLimit) {
        return c.x() * yLimit + c.y();
    }

    private List<List<Coordinate>> adjList(Board board) {
        List<List<Coordinate>> out = new ArrayList<>();

        for (int x = 0; x < board.getXSize(); x++) {
            for (int y = 0; y < board.getYSize(); y++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (!typeFromCoordinate(coordinate, board).equals(FieldType.FARMLAND)) {
                    out.add(new ArrayList<>());
                }

                List<Coordinate> a = new ArrayList<>();
                for (Coordinate n : neighbours(coordinate, board)) {
                    if (typeFromCoordinate(n, board).equals(FieldType.FARMLAND)) {
                        a.add(n);
                    }
                }
                out.add(a);
            }
        }
        return out;
    }

    private FieldType typeFromCoordinate(Coordinate coordinate, Board board) {
        return board.getMatrix()[coordinate.x()][coordinate.y()].getFieldType();
    }

    private Collection<Coordinate> neighbours(Coordinate start, Board board) {

        Set<Coordinate> neighbours = new HashSet<>();

        int x = start.x();
        int y = start.y();

        Coordinate left = new Coordinate(x - 1, y);
        Coordinate right = new Coordinate(x + 1, y);
        Coordinate up = new Coordinate(x, y - 1);
        Coordinate down = new Coordinate(x, y + 1);

        if (left.valid(board.getXSize(), board.getYSize())) {
            neighbours.add(left);
        }
        if (right.valid(board.getXSize(), board.getYSize())) {
            neighbours.add(right);
        }
        if (up.valid(board.getXSize(), board.getYSize())) {
            neighbours.add(up);
        }
        if (down.valid(board.getXSize(), board.getYSize())) {
            neighbours.add(down);
        }

        return neighbours;

    }

}
