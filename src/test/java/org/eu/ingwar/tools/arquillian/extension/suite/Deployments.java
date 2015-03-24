package org.eu.ingwar.tools.arquillian.extension.suite;

/*
 * #%L
 * Arquillian suite extension
 * %%
 * Copyright (C) 2013 Ingwar & co.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.eu.ingwar.tools.arquillian.extension.deployment.EarGenericBuilder;
import org.eu.ingwar.tools.arquillian.extension.deployment.ModuleType;
import org.eu.ingwar.tools.arquillian.extension.groups.AlphaGroup;
import org.eu.ingwar.tools.arquillian.extension.suite.ejb.TestBean;
import org.eu.ingwar.tools.arquillian.extension.suite.normal.Extension1Test;
import org.eu.ingwar.tools.arquillian.extension.suite.inject.InjectedObject;
import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.eu.ingwar.tools.arquillian.extension.suite.extra.ExtensionExtra1Test;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.annotations.AfterClass;
import org.jboss.arquillian.testng.Arquillian;

@ArquillianSuiteDeployment
public class Deployments extends Arquillian {

    @AfterClass
    static public void afterClass() {
        System.out.println("afterClass");
    }

    @Deployment(name = "normal", order = 3)
    @TargetsContainer("app")
    public static Archive<?> generateDefaultDeployment() {
        return ShrinkWrap.create(WebArchive.class, "normal.war")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClass(Deployments.class)
                .addClass(InjectedObject.class)
                .addPackage(AlphaGroup.class.getPackage())
                //.addPackage(AllTests.class.getPackage())
                .addPackage(Extension1Test.class.getPackage());
    }
    
    @Deployment(name = "extra", order = 4)
    @TargetsContainer("app")
    public static Archive<?> generateExtraDeployment() {
        Archive<?> ejb = ShrinkWrap.create(WebArchive.class, "extra_ejb.war")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClass(Deployments.class)
                .addClass(InjectedObject.class)
                .addPackage(AlphaGroup.class.getPackage())
                .addPackage(TestBean.class.getPackage())
                //.addPackage(AllTests.class.getPackage())
                .addPackage(ExtensionExtra1Test.class.getPackage());
        return ejb;
    }

}
