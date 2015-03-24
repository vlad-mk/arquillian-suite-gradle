package org.eu.ingwar.tools.arquillian.extension.suite.extra;

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
import org.eu.ingwar.tools.arquillian.extension.suite.Deployments;
import org.eu.ingwar.tools.arquillian.extension.suite.inject.InjectedObject;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.testng.Arquillian;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.runner.RunWith;

//@RunWith(Arquillian.class)
public class ExtensionExtra1Test extends Deployments {

    @AfterClass
    static public void afterClass() {};
    @AfterMethod
    public void after() {};
    @Test
    @OperateOnDeployment("extra")
    public void shouldInject(InjectedObject bm) {
        Assert.assertNotNull(bm);
        Assert.assertEquals(ExtendedInjectedObject.NAME, bm.getName());
        System.out.println("extra Test1 A");
    }
}
