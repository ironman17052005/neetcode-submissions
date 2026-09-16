class Solution {
    func foreignDictionary(_ words: [String]) -> String {
// Map each unique character to a set of letters that come after it
        var adj = [Character: Set<Character>]()
        for word in words {
            for char in word {
                adj[char] = Set<Character>()
            }
        }
        
        // Convert words to character arrays for faster O(1) indexed lookups
        let wordArray = words.map { Array($0) }
        
        // Populate the graph by comparing adjacent words
        for i in 0..<(wordArray.count - 1) {
            let w1 = wordArray[i]
            let w2 = wordArray[i + 1]
            let minLen = min(w1.count, w2.count)
            
            // Edge case: If w2 is a prefix of w1 but comes after it, the order is invalid
            if w1.count > w2.count && Array(w1[0..<minLen]) == Array(w2[0..<minLen]) {
                return ""
            }
            
            for j in 0..<minLen {
                if w1[j] != w2[j] {
                    adj[w1[j]]?.insert(w2[j])
                    break // Only the first differing character determines the order
                }
            }
        }
        
        // State tracking: nil = unvisited, false = visiting (in current path), true = fully visited
        var visited = [Character: Bool]()
        var result = [Character]()
        
        func dfs(_ char: Character) -> Bool {
            if let isVisited = visited[char] {
                return isVisited // Returns true if safe, false if a cycle is found
            }
            
            visited[char] = false // Mark as visiting (currently on the stack)
            
            if let neighbors = adj[char] {
                for neighbor in neighbors {
                    if !dfs(neighbor) {
                        return false // Cycle detected
                    }
                }
            }
            
            visited[char] = true // Mark as fully processed
            result.append(char)
            return true
        }
        
        // Run DFS for every unique character
        for char in adj.keys {
            if !dfs(char) {
                return ""
            }
        }
        
        // DFS post-order accumulation yields reverse topological order, so reverse it
        return String(result.reversed())
    }
}
