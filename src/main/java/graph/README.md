# Graph Package

Implementations of graph representations and classic graph algorithms.

## Representations

| Class | Storage | Weighted | Space | `hasEdge` | Notes |
|-------|---------|----------|-------|-----------|-------|
| `DenseGraph` | Adjacency matrix `int[][]` | No | `O(V²)` | `O(1)` | `getAllAdjacentEdges` is `O(V)`; rejects parallel edges |
| `SparseGraph` | Adjacency list `ArrayList<ArrayList<Integer>>` | No | `O(V+E)` | `O(degree)` | Allows parallel edges (dedup skipped for perf); richest API |
| `WeightedDenseGraph` | Adjacency matrix `Edge[][]` | Yes | `O(V²)` | `O(1)` | Defines the shared `Edge {a, b, weight}` inner class; only `addEdge`/`hasEdge` so far |
| `WeightedSparseGraph` | Adjacency list `ArrayList<ArrayList<Edge>>` | Yes | `O(V+E)` | see note | Reuses `WeightedDenseGraph.Edge`; mirrors `SparseGraph`'s traversal API |

All four support directed and undirected graphs via a `directed` flag; for undirected graphs an edge is stored in both endpoints' lists/cells (self-loops excepted).

## Algorithms implemented (in `SparseGraph` / `WeightedSparseGraph`)

- **DFS** — `DFS`, recursive `DFSUtil`
- **BFS** — `BFS` using an `ArrayDeque`, guarded by an `entrancedQueue[]` flag to avoid re-enqueueing
- **Connected components** — `getConnectedComponentCount`, `getAllConnectedComponent` (returns the vertex list of each component)
- **Cycle detection** — `isCyclic` / `hasCycle` (parent-tracking DFS for undirected graphs); plus experimental `hasLoop` / `hasLoop2` backtracking variants
- **Path finding** — `hasPath`, `getOnePath` + `showPath` (a DFS path via a `from` map)
- **Shortest path (unweighted)** — `getNearestPath` + `showNearestPath` (BFS with a `from` map to reconstruct the fewest-edges path)

## Algorithm stubs (not yet implemented)

| Directory | Class | Purpose |
|-----------|-------|---------|
| `MinimumSpanningTree/` | `MST`, `Prim`, `Kruskal` | Minimum spanning tree (Prim's / Kruskal's) |
| `SingleSourceShortestPath/` | `Dijsktra`, `BellmanFord` | Weighted single-source shortest path |
| `TopologicalSort/` | `Kahn` | Topological sort via Kahn's algorithm (BFS / in-degree) |

## Known issues / TODO

- `WeightedSparseGraph.hasEdge(v, w)` calls `g.get(v).contains(w)`, but the list holds `Edge` objects, so comparing against an `Integer` always returns `false`. Needs to scan for an `Edge` whose `.b == w`.
- `SparseGraph.hasLoop` / `hasLoop2` are marked `todo has a bug` in the source — treat as experimental; `isCyclic`/`hasCycle` is the reliable undirected-cycle check.
- `SparseGraph.hasEdge` throws `RuntimeException` on out-of-range vertices while `addEdge`/`removeEdge` silently return — inconsistent boundary handling across methods.
- Directed-graph cycle detection is not implemented (current logic assumes undirected via parent tracking).
- The stub algorithm classes above are empty placeholders.

## Quick start

`SparseGraph.main` demonstrates building an undirected graph, cycle detection, connected components, BFS, and shortest-path reconstruction.
