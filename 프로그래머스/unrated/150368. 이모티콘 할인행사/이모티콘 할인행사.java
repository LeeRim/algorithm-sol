import java.util.*;

class Solution {

    List<UserInfo> userInfos;
    PriorityQueue<Result> results;

    public int[] solution(int[][] users, int[] emoticons) {
        results = new PriorityQueue<>();
        userInfos = new ArrayList<>();
        for (int[] user : users) {
            userInfos.add(new UserInfo(user[0], user[1]));
        }

        getEmoticonsRateCombi(emoticons, 0, new Price[emoticons.length]);

        Result re = results.peek();
        int[] answer = {re.joinCount, re.salePrice};
        return answer;
    }

    public void getEmoticonsRateCombi(int[] emoticons, int index, Price[] prices) {
        if (index == emoticons.length) {
            getResult(prices);
            return;
        }

        int rate;
        for (int i = 1; i <= 4; i++) {
            rate = i * 10;
            prices[index] = new Price(rate, (int) (emoticons[index] * (100 - rate) / 100));
            getEmoticonsRateCombi(emoticons, index + 1, prices.clone());
        }
    }

    public void getResult(Price[] prices) {
        int joinCount = 0;
        int totalPrice = 0;

        int userTotalPrice;
        for (UserInfo userInfo : userInfos) {
            userTotalPrice = 0;
            for (Price price : prices) {
                if (userInfo.rateVal <= price.rate) {
                    userTotalPrice += price.price;
                }
            }
            if (userTotalPrice >= userInfo.maxPrice) {
                joinCount++;
            } else {
                totalPrice += userTotalPrice;
            }
        }

        if (results.isEmpty() || joinCount >= results.peek().joinCount) {
            results.add(new Result(joinCount, totalPrice));
        }
    }

    class UserInfo {
        private int rateVal;
        private int maxPrice;

        public UserInfo(int rateVal, int maxPrice) {
            this.rateVal = rateVal;
            this.maxPrice = maxPrice;
        }
    }

    class Result implements Comparable<Result> {
        private int joinCount;
        private int salePrice;

        public Result(int joinCount, int salePrice) {
            this.joinCount = joinCount;
            this.salePrice = salePrice;
        }

        @Override
        public int compareTo(Result o) {
            if (this.joinCount == o.joinCount) {
                return o.salePrice - this.salePrice;
            }
            return o.joinCount - this.joinCount;
        }
    }

    class Price {
        private int rate;
        private int price;

        public Price(int rate, int price) {
            this.rate = rate;
            this.price = price;
        }
    }
}