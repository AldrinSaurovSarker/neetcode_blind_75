class Twitter {
    Map<Integer, Set<Integer>> following;
    PriorityQueue<int[]> tweets;
    int feedCount;
    int currentTime;

    public Twitter() {
        following = new HashMap<>();
        tweets = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        feedCount = 10;
        currentTime = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.offer(new int[]{userId, tweetId, currentTime});
        currentTime++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> userFollowing = following.getOrDefault(userId, Collections.emptySet());
        PriorityQueue<int[]> copy = new PriorityQueue<>(tweets);

        while (!copy.isEmpty() && feed.size() < feedCount) {
            int[] tweet = copy.poll();
            
            if (tweet[0] == userId || userFollowing.contains(tweet[0])) {
                feed.add(tweet[1]);
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> userFollowing = following.get(followerId);

        if (userFollowing != null) {
            userFollowing.remove(followeeId);
        }
    }
}
