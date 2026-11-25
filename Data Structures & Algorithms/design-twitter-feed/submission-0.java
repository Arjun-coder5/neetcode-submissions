class Twitter {
   HashMap<Integer,List<int[]>> tweets;
   HashMap<Integer,HashSet<Integer>> follow;
   int time = 0;
    public Twitter() {
        tweets = new HashMap<>();
        follow = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)){
         tweets.put(userId,new ArrayList<>());
        }
            tweets.get(userId).add(new int[]{time++,tweetId});
    }

    
    public List<Integer> getNewsFeed(int userId) {
         HashSet<Integer> users = new HashSet<>();
    users.add(userId);

    if (follow.containsKey(userId)) {
        users.addAll(follow.get(userId));
    }

    List<int[]> allTweets = new ArrayList<>();
    for (int user : users) {
        if (tweets.containsKey(user)) {
            allTweets.addAll(tweets.get(user));
        }
    }
     allTweets.sort((a,b)->Integer.compare(b[0],a[0]));
    List<Integer> result = new ArrayList<>();
    for(int i = 0;i<Math.min(10,allTweets.size());i++){
        result.add(allTweets.get(i)[1]);
    }
       return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!follow.containsKey(followerId)){
            follow.put(followerId,new HashSet<>());
        }
        follow.get(followerId).add(followeeId);
    }
    
   public void unfollow(int followerId, int followeeId) {

    if (follow.containsKey(followerId)) {
        follow.get(followerId).remove(followeeId);
    }
}
}
