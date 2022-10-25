package bnymellon.codekatas.codepointkata;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.eclipse.collections.api.bag.primitive.CharBag;
import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.factory.primitive.CharBags;
import org.eclipse.collections.impl.string.immutable.CodePointList;

public final class CodePointKata {

    private static List<Integer> readCodes(final URL url) throws Exception {
        final Path path = Paths.get(url.toURI());
        final List<String> lines = Files.lines(path).toList();
        final List<String> stringCodes = new ArrayList<>();
        lines.forEach(line -> {
            for (String code : line.split(" ")) {
                stringCodes.add(code);
            }
        });

        final List<Integer> codes = new ArrayList<>();
        for (String code : stringCodes) {
            codes.add(Integer.valueOf(code));
        }
        return codes;
    }

    private static String convertCodeToString(final Integer code) {
        return CodePointList.from(code).makeString();
    }

    public static List<String> urlToString(final URL url) throws Exception {
        final List<Integer> codes = readCodes(url);
        return codes.stream()
            .map(CodePointKata::convertCodeToString)
            .collect(Collectors.toList());
    }


    public static CharBag groupCharacters(final List<String> list) {
        final Map<Character, Integer> characterGroupings = new HashMap<>();
        for (char c : String.join("", list).toCharArray()) {
            characterGroupings.putIfAbsent(c, 0);
            characterGroupings.put(c, characterGroupings.get(c) + 1);
        }
        final MutableCharBag charBag = CharBags.mutable.empty();
        characterGroupings.forEach((key, value) -> charBag.addOccurrences(key, value));
        return charBag;
    }

    public static String convertCodePointsToString(int... codePoints) {
        return CodePointList.from(codePoints).makeString("");
    }
}
