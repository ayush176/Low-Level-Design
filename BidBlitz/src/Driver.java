import enums.Command;
import services.BidBlitzService;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        BidBlitzService bidBlitzService = new BidBlitzService();

        while(true){
            Scanner sc = new Scanner(System.in);
            Command command = Command.valueOf(sc.next());
            switch (command) {
                case ADD_MEMBER:
                    bidBlitzService.addMember(sc.nextInt(),sc.next(),sc.nextInt());
                    break;
                case ADD_EVENT:
                    bidBlitzService.addEvent(sc.nextInt(),sc.next(),sc.next(),sc.nextInt());
                    break;
                case REGISTER_MEMBER:
                    bidBlitzService.registerMember(sc.nextInt(),sc.nextInt());
                    break;
                case SUBMIT_BID:
                    bidBlitzService.sumbitBid(sc.nextInt(), sc.nextInt(), sc.nextLine());
                    break;
                case DECLARE_WINNER:
                    bidBlitzService.declareWinner(sc.nextInt());
                    break;
                case EXIT:
                    return;
            }
        }
    }
}

