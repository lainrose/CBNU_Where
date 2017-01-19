package cbnuwhere.android.software.cbnu.com.cbnu_where;

import java.util.ArrayList;

/**
 * Created by son on 2017-01-14.
 */

public class DataBase {
    public static String category = "";
    public static String names[] = {"짱구", "인앤아웃", "한빛스테이션", "넷큐브피시클럽", "몽블랑",
            "인터코리아", "킹왕짱", "짱구", "짱구", "인앤아웃",
            "한빛스테이션", "넷큐브피시클럽", "몽블랑", "인터코리아",
            "킹왕짱", "짱구"};

    public static String[] startTimes = {"09", "09", "09", "09", "09",
            "09", "09", "09", "09", "09", "09", "09", "09",
            "09", "09", "09"};

    public static String[] endTimes = {"24", "24", "24", "24", "24",
            "24", "24", "24", "24", "24", "24", "24", "24",
            "24", "24", "24"};

    public static String[] latitudes = {"35.844100", "35.844100", "35.844100", "35.844100", "35.844100",
            "35.844100", "35.844100", "35.844100", "35.844100", "35.844100",
            "35.844100", "35.844100", "35.844100", "35.844100", "35.844100",
            "35.844100"};

    public static String[] longitudes = {"127.126694", "127.126694", "127.126694", "127.126694", "127.126694",
            "127.126694", "127.126694", "127.126994", "127.126694", "127.126694",
            "127.126694", "127.126694", "127.126694", "127.126694", "127.126694",
            "127.126994"};

    public static String[] categorys = {"pcBang", "clawGame", "karaoke", "dringkingBar", "foodStore",
            "billiards", "pcBang", "pcBang", "pcBang", "clawGame",
            "karaoke", "dringkingBar", "foodStore", "billiards", "pcBang",
            "pcBang"};

    public static String pcBang = "pcBang";
    public static String clawGame = "clawGame";
    public static String karaoke = "karaoke";
    public static String dringkingBar = "dringkingBar";
    public static String foodStore = "foodStore";
    public static String billiards = "billiards";
    public static String motel = "motel";
    public static String hairshop = "hairshop";

    public static Integer[] images= {
            R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout,
            R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout,
            R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout,
            R.drawable.inandout};

    public static String animationDirection="";

    ArrayList<ItemModel> listItems = new ArrayList<>();
    ArrayList<ItemModel> categoryListItems = new ArrayList<>();

    public DataBase(){
        listItems.clear();
        categoryListItems.clear();
        for(int i =0;i<names.length;i++){
            ItemModel item = new ItemModel();
            item.setName(DataBase.names[i]);
            item.setStartTime(DataBase.startTimes[i]);
            item.setEndTile(DataBase.endTimes[i]);
            item.setLatitude(DataBase.latitudes[i]);
            item.setLongitude(DataBase.longitudes[i]);
            item.setCategory(DataBase.categorys[i]);
            item.setImage(DataBase.images[i]);
            listItems.add(item);
        }
    }

}
