package com.amazonelinux.asciidoctor;

import org.springframework.stereotype.Service;
import java.io.File;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.asciidoctor.Asciidoctor;
import static org.asciidoctor.Asciidoctor.Factory.create;
import org.asciidoctor.Attributes;
import static org.asciidoctor.AttributesBuilder.attributes;
import static org.asciidoctor.OptionsBuilder.options;
import org.asciidoctor.SafeMode;

/**
 *
 * @author Huynh Tan Vy
 * @email huynhtanvy@fabercompany.co.jp
 */
@Service
public class AsciidoctorServiceImpl {
    
    @PostConstruct
    public void startAsciidoctor() {
        System.out.println("-----------------* Start project *-----------------");
        String atest = "";
        System.out.println("StringUtils: " + StringUtils.isEmpty(atest));
        
        
        Asciidoctor asciidoctor = create();
        Attributes attributes = attributes().attribute("allow-uri-read").get();
        Map<String, Object> options = options()
                .safe(SafeMode.UNSAFE)
                .toFile(new File("C:/work/adoc/result-pdf/report.pdf"))
                .inPlace(true)
                .backend("pdf")
                .attributes(attributes)
                .asMap();


        String contentAdoc = "= Welcome to AsciiDocLIVE! \n\n";
        contentAdoc += "AsciiDocLIVE is a *free online editor*. \n\n";
        contentAdoc += "* Just type AsciiDoc source text into the *left* pane, \n";
        contentAdoc += "* ...and the live preview appears in the *right* pane! \n";
        System.out.println(contentAdoc);

        asciidoctor.convert(contentAdoc, options);
        System.out.println("done");
    }
    
}
