package org.eu.ingwar.tools.arquillian.extension.suite;

import org.eu.ingwar.tools.arquillian.extension.suite.extra.ExtensionExtra1Test;
import org.eu.ingwar.tools.arquillian.extension.suite.extra.ExtensionExtraEjbTest;
import org.eu.ingwar.tools.arquillian.extension.suite.normal.Extension1Test;
import org.eu.ingwar.tools.arquillian.extension.suite.normal.Extension2Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
//import org.testng.runner.RunWith;
//import org.testng.runners.Suite;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({PartnerLocalServiceJTest.class, PartnerMdbTest.class})
//@Suite.SuiteClasses({Extension1Test.class, Extension2Test.class, ExtensionExtra1Test.class, ExtensionExtraEjbTest.class})
public class AllTests {
    @AfterClass
    static public void afterClass() {};

    @AfterMethod
    public void after() {
        System.out.println("after ...");
    }
}
