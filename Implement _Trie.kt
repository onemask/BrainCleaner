class Trie {
    /** Initialize your data structure here. */
    private val tries = mutableListOf<String>()

    /** Inserts a word into the trie. */
    fun insert(word: String) = tries.add(word)


    /** Returns if the word is in the trie. */
    fun search(word: String)= tries.contains(word)

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String) = tries.find { it.startsWith(prefix) } != null
}
