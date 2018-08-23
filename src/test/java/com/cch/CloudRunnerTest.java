package com.cch;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class CloudRunnerTest extends BlockJUnit4ClassRunner {

	public CloudRunnerTest(Class<?> klass) throws InitializationError {
		super(klass);
		System.out.println("CloudRunnerTest::()" + klass);
	}
	@Override
	protected void runChild(FrameworkMethod method, RunNotifier notifier) {
		System.out.println("CloudRunnerTest run Child");
		super.runChild(method, notifier);
	}

}
