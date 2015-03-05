package org.eu.ingwar.tools.arquillian.extension.suite;

import org.eu.ingwar.tools.arquillian.extension.suite.extra.ExtensionExtra1Test;
import org.eu.ingwar.tools.arquillian.extension.suite.extra.ExtensionExtraEjbTest;
import org.eu.ingwar.tools.arquillian.extension.suite.normal.Extension1Test;
import org.eu.ingwar.tools.arquillian.extension.suite.normal.Extension2Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by b1859 - Vladislav Mikerin on 3/3/15.
 */
@RunWith(Suite.class)
//@Suite.SuiteClasses({PartnerLocalServiceJTest.class, PartnerMdbTest.class})
@Suite.SuiteClasses({Extension1Test.class, Extension2Test.class, ExtensionExtra1Test.class, ExtensionExtraEjbTest.class})
public class AllTests {
    @AfterClass
    static public void afterClass() {};

    @After
    public void after() {
        System.out.println("after ...");
    }
}
