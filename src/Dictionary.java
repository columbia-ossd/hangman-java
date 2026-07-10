import java.util.Random;

public class Dictionary {
    public static final int WASHINGTON = 1;
    public static final int NEW_YORK = 2;


    private static final String[] WASHINGTON_WORDS = {
        "Seattle", "Spokane", "Tacoma", "Vancouver", "Bellevue", "Kent",
        "Everett", "Renton", "Yakima", "Kirkland", "Bellingham", "Auburn",
        "Redmond", "Lakewood", "Shoreline", "Olympia", "Bothell", "Edmonds",
        "Lynnwood", "Pullman", "Mukilteo", "Monroe", "Snoqualmie",
        "Leavenworth", "Arlington", "Brier", "Snohomish"
    };
    private static final String[] NEW_YORK_WORDS = {
        "Albany", "Buffalo", "Rochester", "Syracuse", "Yonkers", "Schenectady",
        "Utica", "Troy", "Ithaca", "Poughkeepsie", "Binghamton",
        "Elmira", "Watertown", "Oswego", "Rome", "Newburgh", "Middletown",
        "Kingston", "Batavia", "Geneva", "Cortland", "Oneonta", "Amsterdam",
        "Auburn", "Beacon", "Canandaigua", "Cohoes", "Corning", "Dunkirk",
        "Fulton", "Gloversville", "Hempstead", "Hornell", "Jamestown",
        "Johnstown", "Lackawanna", "Lockport", "Malone", "Massena",
        "Norwich", "Ogdensburg", "Olean", "Oneida", "Peekskill",
        "Plattsburgh", "Potsdam", "Salamanca", "Tonawanda",
        "Brooklyn", "Queens", "New York"
    };

    private static final Random RANDOM = new Random();

    private final String[] words;
    private final String category;

    public Dictionary() {
        this(WASHINGTON);
    }

    public Dictionary(int citySet) {
        if (citySet == NEW_YORK) {
            words = NEW_YORK_WORDS;
            category = "New York State cities";
        } else {
            words = WASHINGTON_WORDS;
            category = "Washington State cities";
        }
    }

    public String getRandomWord() {
        return words[RANDOM.nextInt(words.length)];
    }

    public String getCategory() {
        return category;
    }
}
