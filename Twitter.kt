class Twitter() {

  inner class Tweet(
        val userId: Int, 
        val tweetId: Int,
        val timeLog: Int
    )

    private var tweetMap = hashMapOf<Int, ArrayList<Tweet>>()
    private var friendMap = hashMapOf<Int, ArrayList<Int>>()
    private var timeLog = 0

    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        if (tweetMap.containsKey(userId).not())
            tweetMap[userId] = arrayListOf()

        tweetMap[userId]?.run {
            add(Tweet(userId, tweetId, timeLog))
            timeLog++
        }

    }

    fun getNewsFeed(userId: Int): List<Int> {
        val feeds = ArrayList<Tweet>()
        tweetMap[userId]?.run {
            feeds.addAll(this)
        }
        friendMap[userId]?.map { id ->
            tweetMap[id]?.filter { it.userId == id }?.run {
                feeds.addAll(this)
            }
        }
        feeds.sortByDescending { it.timeLog }
        return feeds.map { it.tweetId }.distinctBy { it }.take(10)
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        if (friendMap.containsKey(followerId).not())
            friendMap[followerId] = arrayListOf()
        friendMap[followerId]?.add(followeeId)
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        if (friendMap.containsKey(followerId).not())
            return
        else
            friendMap[followerId]?.remove(followeeId)
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */
