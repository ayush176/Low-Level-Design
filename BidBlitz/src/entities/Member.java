package entities;

public class Member {
    int memberId;
    String memberName;
    int noOfSuperCoins;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getNoOfSuperCoins() {
        return noOfSuperCoins;
    }

    public void setNoOfSuperCoins(int noOfSuperCoins) {
        this.noOfSuperCoins = noOfSuperCoins;
    }

    public Member(int memberId, String memberName, int noOfSuperCoins) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.noOfSuperCoins = noOfSuperCoins;
    }
}
