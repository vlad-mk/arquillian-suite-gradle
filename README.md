# arquillian-suite-gradle


test project

Test with gradle:
```
gradle --daemon  cleanTest test
```

Test with maven:
```
mvn -P wildfly-remote clean
```

This part is missing in gradle test:

```
(E) AfterSuite
  (I) TestContextHandler.createSuiteContext
  (O) ContainerEventController.execute
  (E) StopSuiteContainers
	(O) ContainerLifecycleController.stopSuiteContainers
	(E) StopContainer
	  (I) ContainerDeploymentContextHandler.createContainerContext
	  (O) ContainerLifecycleController.stopContainer
	  (E) BeforeStop
		(O) ArquillianServiceDeployer.undeploy
		(O) SuiteDeployer.undeploy
Mar 05, 2015 9:26:14 AM org.eu.ingwar.tools.arquillian.extension.suite.ArquillianSuiteExtension$SuiteDeployer debug
WARNING: Catching BeforeStop event org.jboss.arquillian.container.spi.event.container.BeforeStop@359a9570
		(E) UnDeployManagedDeployments
		  (I) SuiteDeployer.blockUnDeployManagedDeploymentsWhenNeeded
Mar 05, 2015 9:26:14 AM org.eu.ingwar.tools.arquillian.extension.suite.ArquillianSuiteExtension$SuiteDeployer debug
WARNING: NOT Blocking UnDeployManagedDeployments event org.jboss.arquillian.container.spi.event.UnDeployManagedDeployments@37c9078e
		  (O) ContainerDeployController.undeployManaged
		  (E) UnDeployDeployment
			(I) ContainerDeploymentContextHandler.createContainerContext
			(I) ContainerDeploymentContextHandler.createDeploymentContext
			(O) ContainerDeployController.undeploy
			(E) BeforeUnDeploy
			(E) AfterUnDeploy
			  (O) ServerSetupObserver.handleAfterUndeploy
		  (E) UnDeployDeployment
			(I) ContainerDeploymentContextHandler.createContainerContext
			(I) ContainerDeploymentContextHandler.createDeploymentContext
			(O) ContainerDeployController.undeploy
			(E) BeforeUnDeploy
			(E) AfterUnDeploy
			  (O) ServerSetupObserver.handleAfterUndeploy
	  (E) AfterStop
  (O) ServerKillerExtension.throwErrpr
(E) ManagerStopping

```