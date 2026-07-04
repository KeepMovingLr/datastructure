# datastructure

A personal study repository where I implement classic **data structures and algorithms from scratch** in Java, and work through **LeetCode / interview problems** organized by technique.

Everything here is built by hand — no `java.util` shortcuts for the core structures — as a way to really understand how they work.

## Tech stack

- **Java 8**
- **Maven** (`groupId: ray`, `artifactId: datastructure`)
- **JUnit 4 / JUnit 5** for tests

## Getting started

```bash
# Compile everything
mvn compile

# Run tests
mvn test
```

Most packages are self-contained and include their own `Main` or test harness you can run directly from your IDE.

## Repository layout

The code lives in `src/main/java/` and splits into two halves.

### 1. Hand-built data structures & algorithms

| Package | Contents |
|---|---|
| `array` | Dynamic array, plus prefix-sum (`prefix/PreFix`) |
| `linkedlist` | Singly linked list |
| `stack` | Array-based and linked-list-based stacks |
| `queue` | Loop (circular) queue, priority queue, array & linked queues |
| `maxheap` | `MaxHeap` and `IndexMaxHeap` |
| `tree` | Binary search tree (recursive & non-recursive), AVL tree, binary search |
| `setandmap` | `Set` / `Map` interfaces with BST- and linked-list-backed implementations |
| `trie` | Prefix tree |
| `hashtable` | Hash table |
| `skiplist` | Skip list |
| `unionFind` | Six progressive versions (`UnionFind1`→`UnionFind6`): quick-find → union-by-rank → path compression |
| `segmenttree` | Basic, lazy-propagation, and dynamic segment trees, plus calendar-booking usages |
| `graph` | Sparse/dense (weighted) graphs, MST (Kruskal, Prim), shortest path (Dijkstra, Bellman-Ford), topological sort (Kahn) |
| `sort` | Sorting algorithms with shared test utilities |
| `recursion` | Recursion basics |
| `dynamicprogramming` | Fibonacci, 0/1 knapsack |
| `backtracking` | Permutations, combination-sum style problems |

### 2. LeetCode & interview practice

Solutions are grouped by **technique**, not just by problem number, so related problems sit together.

- **`lc/`** — LeetCode solutions by category:
  - `array/` — including `twopointer/` and `twopointer/slidingwindow/`
  - `list/` — linked-list problems
  - `tree/`, `trie/`, `graph/`, `unionFind/`, `segmenttree/`
  - `stack/`, `queue/`, `heap/` (with `heap/top_k/`)
  - `backtracking/`, `dynamicprogramming/`, `hashtable/`, `sort/`, `math/`
  - `collection/` — problems solved with maps/sets
  - `attempted/` — in-progress problems
- **`others/interview/`** — company-tagged questions (Amazon, Google, Microsoft, Flexport, Shopee, Datavisor, …)
- **`others/wordcounter/`** — word-frequency utility

#### Naming conventions

Two styles coexist as the repo evolved:

- `SolutionNNN.java` — older style, problem number only
- `S_NNN_DescriptiveName.java` — newer style, number + problem name

A `_2`, `_3`, … suffix marks **alternative approaches** to the same problem (e.g. `S_39_CombinationSum`, `S_39_CombinationSum_2`).

## Test data

`a-tale-of-two-cities.txt` and `pride-and-prejudice.txt` are plain-text books used as input for word-frequency exercises (`setandmap/FileOperation`, `others/wordcounter`).
