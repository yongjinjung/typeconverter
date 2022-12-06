package hello.typeconverter.converter;


import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @Test
    @DisplayName("문자를숫자로 타입변환")
    void stringToInteger(){
        StringToIntegerConverter con = new StringToIntegerConverter();
        Integer result = con.convert("10");

        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("숫자를문자로 타입변환")
    void IntegerToString(){
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        Assertions.assertThat(result).isEqualTo("10");
    }

    @Test
    void ipPortToString() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(ipPort);
        Assertions.assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void stringToIpPort(){
        StringToIpPortConverter converter = new StringToIpPortConverter();
        IpPort result = converter.convert("127.0.0.1:8080");
        Assertions.assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

}
