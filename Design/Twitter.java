/**
 * 355. 设计推特
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

package LeetcodeJava.Design;

import java.util.*;

class Twitter {

    public Map<Integer, Set<Integer>> followList;
    public Map<Integer,Tweet> tweetsList;
    public static int timestamp = 0;

    public static class Tweet{
        private int id;
        private int timestemp;
        private Tweet next;
        public Tweet(int id, int timestamp){
            this.id = id;
            this.timestemp = timestamp;
        }
    }
    /** Initialize your data structure here. */
    public Twitter() {
        followList = new HashMap<>();
        tweetsList = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        //检查该 tweetID 是否存在，没做
//        if()

        //检查 userId 是否在用户列表里
        if(tweetsList.containsKey(userId)){
            //将 tweetId 添加到 User-tweet 的 pair 里
            Tweet tweet = tweetsList.get(userId);
            Tweet newTweet = new Tweet(tweetId, timestamp);
            newTweet.next = tweet;
            tweetsList.put(userId,newTweet);
        }else{
            tweetsList.put(userId, new Tweet(tweetId, timestamp));
            followList.put(userId,new HashSet<Integer>());
        }
        timestamp++;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        int nMostRecent = 10;
        List<Integer> newsFeed = new ArrayList<>();
        //用一个链表来存放 自己和关注的所有人的 tweet 节点（nMostRecent个）
        List<Tweet> newsTweet = new ArrayList<>();

        //如果用户存在
        if(tweetsList.containsKey(userId)){
            //获取该用户和关注的所有人的 tweet 头节点的最近 nMostRecent个
            if(tweetsList.get(userId) != null)
                newsTweet.add(tweetsList.get(userId));

            int i;
            if(followList.get(userId) != null){
                for(Integer user:followList.get(userId)) {
                    //将关注对象的 tweet 节点加入 newsTweet， 只保留最新十个 更新的用户 tweet
                    Tweet t = tweetsList.get(user);
                    if(t == null) continue;
                    //对 user 的最新 tweet
                    for (i = 0; i < newsTweet.size() && i < nMostRecent; i++) {
                        //若存在其他用户的最新 tweet 比其新的就向后挪动
                        if (t.timestemp > newsTweet.get(i).timestemp) break;
                    }
                    //若未挪到超出 数组长度 或者 nMostRecent，则添加
                    if(i < nMostRecent || i < newsTweet.size()){
                        newsTweet.add(i, tweetsList.get(user));
                        if (newsTweet.size() > nMostRecent) newsTweet.remove(nMostRecent);
                    }
                }
            }

            //对十个最新tweet 用户的tweet进行获取
            for(int j = 0; j < newsTweet.size(); j++){
                Tweet newestTweet = newsTweet.get(j);
                newsFeed.add(newestTweet.id);
//                System.out.println("Tweet "+newestTweet.id+" is added to the news.");


                if(newestTweet.next != null){
                    for(i = j+1; i < newsTweet.size() && i < nMostRecent; i++){
                        if(newestTweet.next.timestemp > newsTweet.get(i).timestemp) break;
                    }
                    if(i < nMostRecent || i < newsTweet.size()){
                        newsTweet.add(i, newestTweet.next);
                        if (newsTweet.size() > nMostRecent) newsTweet.remove(nMostRecent);
                    }
                }

            }
        }else{
            System.out.println("There is no User: "+userId);
        }

        return newsFeed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        //检查是否存在用户1
        if(followList.containsKey(followerId)){
            //检查是否 “自关注”
            if(followerId == followeeId) return;
            //follow
            followList.get(followerId).add(followeeId);
        }else{
            //初始化用户 followerId
            tweetsList.put(followerId,null);
            //假如用户 followeeId 也不存在，初始化用户 followeeId
            if(!followList.containsKey(followeeId)){
                tweetsList.put(followeeId,null);
                followList.put(followeeId,new HashSet<Integer>());
            }
            followList.put(followerId,new HashSet<Integer>(){{add(followeeId);}});
//            System.out.println(followerId+" follow "+followeeId+": "+followList.get(followerId));

        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

        //检查是否存在用户1
        if(followList.containsKey(followerId)){
            //检查是否 “自关注”
            if(followerId == followeeId) return;
            //follow
            Set<Integer> following = followList.get(followerId);
            if(following == null) return;
            following.remove(followeeId);
        }else{
            System.out.println("There is no User: "+followerId);
        }
    }

    public static void main(String[] args) {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        System.out.println("NewsFeed of User 1:"+twitter.getNewsFeed(1));

        twitter.postTweet(2, 2);
        twitter.postTweet(2, 3);
        twitter.postTweet(2, 4);
        twitter.postTweet(2, 5);
        twitter.postTweet(2, 6);
        twitter.postTweet(2, 7);
        twitter.postTweet(2, 8);
        twitter.postTweet(1, 9);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 12);
        System.out.println("NewsFeed of User 2:"+twitter.getNewsFeed(2));


        twitter.follow(3, 1);
        System.out.println("NewsFeed of User 3:"+twitter.getNewsFeed(3));

        twitter.follow(3, 2);
        System.out.println("NewsFeed of User 3:"+twitter.getNewsFeed(3));

        twitter.unfollow(3, 1);
        System.out.println("NewsFeed of User 3:"+twitter.getNewsFeed(3));

//["Twitter","postTweet","follow","getNewsFeed"]
//[[],[1,5],[1,1],[1]]
//        Twitter twitter = new Twitter();
//        twitter.postTweet(1, 5);
//        System.out.println("NewsFeed of User 1:"+twitter.getNewsFeed(1));
//        twitter.follow(1, 1);
//
//        System.out.println("NewsFeed of User 1:"+twitter.getNewsFeed(1));

//        Twitter twitter = new Twitter();
//
//        twitter.postTweet(1, 5);
//        System.out.println("NewsFeed of User 1:"+twitter.getNewsFeed(1));
//
//        twitter.follow(1, 2);
//
//        twitter.postTweet(2, 6);
//        System.out.println("NewsFeed of User 1:"+twitter.getNewsFeed(1));
//
//        twitter.unfollow(1, 2);
//        System.out.println("NewsFeed of User 1:"+twitter.getNewsFeed(1));
    }

}

