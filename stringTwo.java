public class stringTwo {

    // Given a string, return a string where for every char in the original, there are two chars.

    // doubleChar("The") → "TThhee"
    // doubleChar("AAbb") → "AAAAbbbb"
    // doubleChar("Hi-There") → "HHii--TThheerree"

    public String doubleChar(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.substring(i, i + 1) + str.substring(i, i + 1);
        }
        return result;
    }

    // Return the number of times that the string "hi" appears anywhere in the given string.

    // countHi("abc hi ho") → 1
    // countHi("ABChi hi") → 2
    // countHi("hihi") → 2

    public int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("hi")) {
                count++;
            }
        }
        return count;
    }


    // Return true if the string "cat" and "dog" appear the same number of times in the given string.

    // catDog("catdog") → true
    // catDog("catcat") → false
    // catDog("1cat1cadodog") → true

    public boolean catDog(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("cat")) {
                count++;
            }
            if (str.substring(i, i + 3).equals("dog")) {
                count--;
            }
        }
        if (count == 0) {
            return true;
        }

        return false;
    }


    // Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.

    // countCode("aaacodebbb") → 1
    // countCode("codexxcode") → 2
    // countCode("cozexxcope") → 2

    public int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.substring(i, i + 4).matches("co[a-zA-Z]e")) {
                count++;
            }
        }
        return count;
    }


    // Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.

    // endOther("Hiabc", "abc") → true
    // endOther("AbC", "HiaBc") → true
    // endOther("abc", "abXabc") → true

    public boolean endOther(String a, String b) {
        String aEnd = "";
        String bEnd = "";

        if (b.length() <= a.length()) {
            aEnd = a.substring(a.length() - b.length()).toLowerCase();
        }
        if (a.length() <= b.length()) {
            bEnd = b.substring(b.length() - a.length()).toLowerCase();
        }

        if (aEnd.equals(b.toLowerCase()) || bEnd.equals(a.toLowerCase())) {
            return true;
        }

        return false;
    }


    // Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.

    // xyzThere("abcxyz") → true
    // xyzThere("abc.xyz") → false
    // xyzThere("xyz.abc") → true

    public boolean xyzThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).matches("xyz")) {
                if (i == 0 || (i > 0 && str.charAt(i - 1) != '.')) {
                    return true;
                }
            }
        }
        return false;
    }


    // Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.

    // bobThere("abcbob") → true
    // bobThere("b9b") → true
    // bobThere("bac") → false

    public boolean bobThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).matches("b[a-zA-Z0-9]b")) {
                return true;
            }
        }
        return false;
    }


    // We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.

    // xyBalance("aaxbby") → true
    // xyBalance("aaxbb") → false
    // xyBalance("yaaxbb") → false

    public boolean xyBalance(String str) {
        int y = str.lastIndexOf('y');

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x' && i > y) {
                return false;
            }
        }

        return true;
    }

    // Given two strings, A and B, create a bigger string made of the first char of A, the first char of B, the second char of A, the second char of B, and so on. Any leftover chars go at the end of the result.

    // mixString("abc", "xyz") → "axbycz"
    // mixString("Hi", "There") → "HTihere"
    // mixString("xxxx", "There") → "xTxhxexre"

    public String mixString(String a, String b) {
        int min = Math.min(a.length(), b.length());
        int max = Math.max(a.length(), b.length());
        String result = "";

        for (int i = 0; i < min; i++) {
            result += a.substring(i, i + 1) + b.substring(i, i + 1);
        }

        return (a.length() > b.length()) ? result + a.substring(min, max) : result + b.substring(min, max); // can be separated into if statements
    }


    // Given a string and an int N, return a string made of N repetitions of the last N characters of the string. You may assume that N is between 0 and the length of the string, inclusive.

    // repeatEnd("Hello", 3) → "llollollo"
    // repeatEnd("Hello", 2) → "lolo"
    // repeatEnd("Hello", 1) → "o"

    public String repeatEnd(String str, int n) {
        String result = "";
        if (n == 0) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            result += str.substring(str.length() - n);
        }

        return result;
    }


    // Given a string and an int n, return a string made of the first n characters of the string, followed by the first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).

    // repeatFront("Chocolate", 4) → "ChocChoChC"
    // repeatFront("Chocolate", 3) → "ChoChC"
    // repeatFront("Ice Cream", 2) → "IcI"

    public String repeatFront(String str, int n) {
        String result = str.substring(0, n);
        if (n == 0) {
            return "";
        }

        for (int i = n - 1; i >= 0; i--) {
            result += result.substring(0, i);
        }

        return result;
    }


    // Given two strings, word and a separator, return a big string made of count occurences of the word, separated by the separator string.

    // repeatSeparator("Word", "X", 3) → "WordXWordXWord"
    // repeatSeparator("This", "And", 2) → "ThisAndThis"
    // repeatSeparator("This", "And", 1) → "This"

    public String repeatSeparator(String word, String sep, int count) {
        String result = "";
        if (count == 0) return result;
        if (count < 2) return word;

        for (int i = 0; i < count; i++) {
            result += word;
            if (i != count - 1) result += sep;
        }

        return result;
    }


    // Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().

    // prefixAgain("abXYabc", 1) → true
    // prefixAgain("abXYabc", 2) → true
    // prefixAgain("abXYabc", 3) → false

    public boolean prefixAgain(String str, int n) {
        String pre = str.substring(0, n);
        if (n == 0) {
            return true;
        }

        for (int i = n; i < str.length() - n + 1; i++) {
            if (pre.equals(str.substring(i, i + n))) {
                return true;
            }
        }

        return false;
    }


    // Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.

    // xyzMiddle("AAxyzBB") → true
    // xyzMiddle("AxyzBB") → true
    // xyzMiddle("AxyzBBB") → false

    public boolean xyzMiddle(String str) {
        int mid = str.length() / 2;
        boolean balanced = str.length() % 2 == 0;
        int pos = str.indexOf("xyz", mid - 3);

        if (pos < 0) return false;
        if (!balanced && mid - 1 == pos) {
            return true;
        } else if (balanced && (mid - 2 == pos || mid - 1 == pos)) {
            return true;
        } else {
            return false;
        }
    }

    // A sandwich is two pieces of bread with something in between. Return the string that is between the first and last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.

    // getSandwich("breadjambread") → "jam"
    // getSandwich("xxbreadjambreadyy") → "jam"
    // getSandwich("xxbreadyy") → ""

    public String getSandwich(String str) {
        int top = str.indexOf("bread");
        int bot = str.lastIndexOf("bread");

        if (top != bot) {
            return str.substring(top + 5, bot);
        } else {
            return "";
        }
    }


    // Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same.

    // sameStarChar("xy*yzz") → true
    // sameStarChar("xy*zzz") → false
    // sameStarChar("*xa*az") → true

    public boolean sameStarChar(String str) {
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*') {
                if (str.charAt(i - 1) == str.charAt(i + 1)) {
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    // Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".

    // zipZap("zipXzap") → "zpXzp"
    // zipZap("zopzop") → "zpzp"
    // zipZap("zzzopzop") → "zzzpzp"

    public String zipZap(String str) {
        int len = str.length() - 2;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
                str = str.substring(0, i + 1) + str.substring(i + 2, str.length());
                len = str.length();
            }
        }

        return str;
    }


    // Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".

    // starOut("ab*cd") → "ad"
    // starOut("ab**cd") → "ad"
    // starOut("sm*eilly") → "silly"

    public String starOut(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '*') {
                if (i > 0 && str.charAt(i - 1) == '*') continue;
                if (i + 1 < str.length() && str.charAt(i + 1) == '*') continue;
                result += str.charAt(i);
            }
        }

        return result;
    }


    // Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.

    // plusOut("12xy34", "xy") → "++xy++"
    // plusOut("12xy34", "1") → "1+++++"
    // plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"

    public String plusOut(String str, String word) {
        int slen = str.length();
        int wlen = word.length();
        String result = "";

        for (int i = 0; i < slen; i++) {
            if (i + wlen - 1 < slen && str.substring(i, i + wlen).equals(word)) {
                result += word;
                i = i + wlen - 1;
            } else {
                result += "+";
            }
        }

        return result;

    }


    // Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words.

    // wordEnds("abcXY123XYijk", "XY") → "c13i"
    // wordEnds("XY123XY", "XY") → "13"
    // wordEnds("XY1XY", "XY") → "11

    public String wordEnds(String str, String word) {
        int slen = str.length();
        int wlen = word.length();
        String result = "";

        for (int i = 0; i < slen - wlen + 1; i++) {
            if (str.substring(i, i + wlen).equals(word)) {
                if (i != 0) {
                    result += str.substring(i - 1, i);
                }
                if (i + wlen != slen) {
                    result += str.substring(i + wlen, i + wlen + 1);
                }
            }
        }
        return result;
    }



}
