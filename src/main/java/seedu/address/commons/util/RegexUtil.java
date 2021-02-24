package seedu.address.commons.util;

/**
 * A container for different regex expressions to check whether the input is valid or not.
 */
public class RegexUtil {

    // Miscellaneous regex expressions
    public static final String SPECIAL_CHARACTERS = "!#$%&'*+/=?`{|}~^.-";

    // Original regex expression for AB3, for reference purposes
    /*
     * The first character of the address and name must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String REGEX_AB3_ADDRESS = "[^\\s].*";
    public static final String REGEX_AB3_NAME = "[\\p{Alnum}][\\p{Alnum} ]*";
    public static final String REGEX_AB3_EMAIL = getAb3EmailRegex();
    public static final String REGEX_AB3_PHONE = "\\d{3,}";
    public static final String REGEX_AB3_TAG = "\\p{Alnum}+";

    // Regex expressions that might be useful in project Weeblingo
    public static final String REGEX_JAP_WORD =
            "[(\\p{InHIRAGANA}|\\p{InKATAKANA})"
            + "|\\p{InCJK_Unified_Ideographs}}]"
            + "[(\\p{InHIRAGANA}|\\p{InKATAKANA})"
            + "|\\p{InCJK_Unified_Ideographs}}]*"; // There should be no spaces in Jap words. \\w at the end?
    public static final String REGEX_JAP_SENTENCE =
            "[(\\p{InHIRAGANA}|\\p{InKATAKANA})|\\p{InCJK_Unified_Ideographs}|"
            + "\\p{InCJK_Symbols_and_Punctuation}]"
            + "[(\\p{InHIRAGANA}|\\p{InKATAKANA})|\\p{InCJK_Unified_Ideographs}|"
                    + "\\p{InCJK_Symbols_and_Punctuation} ]*"; // The first character cannot be space. \\w at the end?
    public static final String REGEX_ENG_WORD = "[\\p{Alpha}]*"; // There should be no spaces in English words.
    public static final String REGEX_ENG_SENTENCE = "[\\p{Alpha}][\\p{Punct}]"
            + "[\\p{Alpha}][\\p{Punct} ]*"; // The first character cannot be space.

    /**
     * Gets the regex expression for AB3 email model.
     *
     * @return The regex expression for AB3 email model.
     */
    private static String getAb3EmailRegex() {
        // alphanumeric and special characters
        final String localPartRegex = "^[\\w" + SPECIAL_CHARACTERS + "]+";
        final String domainFirstCharacterRegex = "[^\\W_]"; // alphanumeric characters except underscore
        final String domainMiddleRegex = "[a-zA-Z0-9.-]*"; // alphanumeric, period and hyphen
        final String domainLastCharacterRegex = "[^\\W_]$";
        return localPartRegex + "@"
                + domainFirstCharacterRegex + domainMiddleRegex + domainLastCharacterRegex;
    }
}
