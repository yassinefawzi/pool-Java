import java.util.*;

public class Regex {
    private StringBuilder pattern;
	//
    public Regex() {
        pattern = new StringBuilder();
    }
	//
    public Regex(List<String> components) {
		//
        pattern = new StringBuilder();
        for (String c : components) {
            pattern.append(c);
        }
    }

    public String getPattern() {
        return pattern.toString();
    }

	//
    @Override
    public String toString() {
        return getPattern();
    }
}


// interface
interface RegexBuilder {
    void buildLiteral(String literal);
    void buildAnyCharacter();
    void buildDigit();
    void buildWhitespace();
    void buildWordCharacter();
    Regex getResult();
}


//////
class ConcreteRegexBuilder implements RegexBuilder {
    private List<String> components = new ArrayList<>();

    @Override
    public void buildLiteral(String literal) {
        components.add(literal);
    }

    @Override
    public void buildAnyCharacter() {
        components.add(".");
    }

    @Override
    public void buildDigit() {
        components.add("\\d");
    }

    @Override
    public void buildWhitespace() {
        components.add("\\s");
    }

    @Override
    public void buildWordCharacter() {
        components.add("\\w");
    }

    @Override
    public Regex getResult() {
        return new Regex(components);
    }
}

class RegexDirector {
    private RegexBuilder builder;

    public void setBuilder(RegexBuilder builder) {
        this.builder = builder;
    }

    public Regex construct() {
        builder.buildLiteral("Hello");
        builder.buildWhitespace();
        builder.buildWordCharacter();
        builder.buildAnyCharacter();
        return builder.getResult();
    }
}

