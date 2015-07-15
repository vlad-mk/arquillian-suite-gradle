# arquillian-suite-gradle


test project

Test with gradle:
```
gradle --daemon  cleanTest test
```

Test with maven:
```
mvn -P wildfly-remote test
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

Gradle realization of JUnit tests(JUnitTestClassExecuter.java), creates a notifier for each class:

```
        Runner runner = request.getRunner();
        //In case of no matching methods junit will return a ErrorReportingRunner for org.junit.runner.manipulation.Filter.class.
        //Will be fixed with adding class filters
        if (!org.junit.runner.manipulation.Filter.class.getName().equals(runner.getDescription().getDisplayName())) {
            RunNotifier notifier = new RunNotifier();
            notifier.addListener(listener);
            runner.run(notifier);
        }

```

maven surfire (JUnit4Provider.java), creates a notifier for a test set:

```
        JUnit4RunListener jUnit4TestSetReporter = new JUnit4RunListener( reporter );

        Result result = new Result();
        RunNotifier runNotifier = getRunNotifier( jUnit4TestSetReporter, result, customRunListeners );

        runNotifier.fireTestRunStarted( createTestsDescription() );

        for ( Class aTestsToRun : testsToRun )
        {
            executeTestSet( aTestsToRun, reporter, runNotifier );
        }

        runNotifier.fireTestRunFinished( result );

        JUnit4RunListener.rethrowAnyTestMechanismFailures( result );

        closeRunNotifier( jUnit4TestSetReporter, customRunListeners );
        return reporterFactory.close();


```
