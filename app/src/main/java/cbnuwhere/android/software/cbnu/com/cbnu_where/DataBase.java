package cbnuwhere.android.software.cbnu.com.cbnu_where;

import android.provider.ContactsContract;

import java.util.ArrayList;

/**
 * Created by son on 2017-01-14.
 */

public class DataBase {

    private static DataBase dataBase;

    public static synchronized DataBase getInstance() {
        if(dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }

    private static Boolean SwitchParm = false;

    private static String category = "";

    public @interface AnimationDirection {}
    public static final int NODIR = 0;
    public static final int UP    = 1;
    public static final int DOWN  = 2;
    public static final int LEFT  = 3;
    public static final int RIGHT = 4;

    public static final long DURATION = 500;
    private static int direction = NODIR;

    private static String[] names = {"짱구", "인앤아웃", "한빛스테이션", "넷큐브피시클럽", "몽블랑",
            "인터코리아", "킹왕짱", "짱구", "짱구", "인앤아웃",
            "한빛스테이션", "넷큐브피시클럽", "몽블랑", "인터코리아",
            "킹왕짱", "짱구"};

    private static String[] startTimes = {"09", "09", "09", "09", "09",
            "09", "09", "09", "09", "09", "09", "09", "09",
            "09", "09", "09"};

    private static String[] endTimes = {"24", "24", "24", "24", "24",
            "24", "24", "24", "24", "24", "24", "24", "24",
            "24", "24", "24"};

    private static String[] latitudes = {"35.844100", "35.844100", "35.844100", "35.844100", "35.844100",
            "35.844100", "35.844100", "35.844100", "35.844100", "35.844100",
            "35.844100", "35.844100", "35.844100", "35.844100", "35.844100",
            "35.844100"};

    private static String[] longitudes = {"127.126694", "127.126694", "127.126694", "127.126694", "127.126694",
            "127.126694", "127.126694", "127.126994", "127.126694", "127.126694",
            "127.126694", "127.126694", "127.126694", "127.126694", "127.126694",
            "127.126994"};

    private static String[] categorys = {"pcBang", "clawGame", "karaoke", "dringkingBar", "foodStore",
            "billiards", "pcBang", "pcBang", "pcBang", "clawGame",
            "karaoke", "dringkingBar", "foodStore", "billiards", "pcBang",
            "pcBang"};

    private static String pcBang = "pcBang";
    private static String clawGame = "clawGame";
    private static String karaoke = "karaoke";
    private static String dringkingBar = "dringkingBar";
    private static String foodStore = "foodStore";
    private static String billiards = "billiards";
    private static String motel = "motel";
    private static String hairshop = "hairshop";
    //2017-01-19 Test
    private static Integer[] images= {
            R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout,
            R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout,
            R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout, R.drawable.inandout,
            R.drawable.inandout};

    private static ArrayList<ItemModel> listItems = new ArrayList<>();
    private static ArrayList<ItemModel> categoryListItems = new ArrayList<>();

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

    public static DataBase getDataBase() {
        return dataBase;
    }

    public static void setDataBase(DataBase dataBase) {
        DataBase.dataBase = dataBase;
    }

    public static Boolean getSwitchParm() {
        return SwitchParm;
    }

    public static void setSwitchParm(Boolean switchParm) {
        SwitchParm = switchParm;
    }

    public static String getCategory() {
        return category;
    }

    public static String[] getNames() {
        return names;
    }

    public static void setNames(String[] names) {
        DataBase.names = names;
    }

    public static String[] getStartTimes() {
        return startTimes;
    }

    public static void setStartTimes(String[] startTimes) {
        DataBase.startTimes = startTimes;
    }

    public static String[] getEndTimes() {
        return endTimes;
    }

    public static void setEndTimes(String[] endTimes) {
        DataBase.endTimes = endTimes;
    }

    public static String[] getLatitudes() {
        return latitudes;
    }

    public static void setLatitudes(String[] latitudes) {
        DataBase.latitudes = latitudes;
    }

    public static String[] getLongitudes() {
        return longitudes;
    }

    public static void setLongitudes(String[] longitudes) {
        DataBase.longitudes = longitudes;
    }

    public static String[] getCategorys() {
        return categorys;
    }

    public static void setCategorys(String[] categorys) {
        DataBase.categorys = categorys;
    }

    public static String getPcBang() {
        return pcBang;
    }

    public static void setPcBang(String pcBang) {
        DataBase.pcBang = pcBang;
    }

    public static String getClawGame() {
        return clawGame;
    }

    public static void setClawGame(String clawGame) {
        DataBase.clawGame = clawGame;
    }

    public static String getKaraoke() {
        return karaoke;
    }

    public static void setKaraoke(String karaoke) {
        DataBase.karaoke = karaoke;
    }

    public static String getDringkingBar() {
        return dringkingBar;
    }

    public static void setDringkingBar(String dringkingBar) {
        DataBase.dringkingBar = dringkingBar;
    }

    public static String getFoodStore() {
        return foodStore;
    }

    public static void setFoodStore(String foodStore) {
        DataBase.foodStore = foodStore;
    }

    public static String getBilliards() {
        return billiards;
    }

    public static void setBilliards(String billiards) {
        DataBase.billiards = billiards;
    }

    public static String getMotel() {
        return motel;
    }

    public static void setMotel(String motel) {
        DataBase.motel = motel;
    }

    public static String getHairshop() {
        return hairshop;
    }

    public static void setHairshop(String hairshop) {
        DataBase.hairshop = hairshop;
    }

    public static Integer[] getImages() {
        return images;
    }

    public static void setImages(Integer[] images) {
        DataBase.images = images;
    }

    public static ArrayList<ItemModel> getListItems() {
        return listItems;
    }

    public static void setListItems(ArrayList<ItemModel> listItems) {
        DataBase.listItems = listItems;
    }

    public static ArrayList<ItemModel> getCategoryListItems() {
        return categoryListItems;
    }

    public static void setCategoryListItems(ArrayList<ItemModel> categoryListItems) {
        DataBase.categoryListItems = categoryListItems;
    }

    public static int getDirection() {
        return direction;
    }

    public static void setDirection(int direction) {
        DataBase.direction = direction;
    }

    public void setCategory(String strParm){
        category = strParm;
        for (ItemModel model : listItems) {
            if (model.getCategory().equals(category)) {
                categoryListItems.add(model);
            }
        }
        if(category.equals("all")){
            categoryListItems.addAll(listItems);
        }
    }

}
