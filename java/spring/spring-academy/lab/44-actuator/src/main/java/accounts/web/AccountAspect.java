package accounts.web;

import accounts.AccountManager;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * TODO-26 (Optional): Use AOP for counting logic
 * - Add `spring-boot-starter-aop` starter to the `pom.xml` or the
 *   `build.gradle`. (You might want to refresh your IDE so that
 *   it picks up the change in the `pom.xml` or the `build.gradle` file.)
 * - Make this class an Aspect, through which `account.fetch` counter,
 *   which has a tag of `type`/`fromAspect` key/value pair, gets incremented
 *   every time `accountSummary` method of the `AccountController` class
 *   is invoked
 * - Make this a component by using a proper annotation
 * - Access `/accounts` several times and verify the metrics of
 *   `/actuator/metrics/account.fetch?tag=type:fromAspect
 */
@Aspect
@Component
public class AccountAspect {
    private Counter counter;

    // TODO-08: Add a Micrometer Counter
    // - Inject a MeterRegistry through constructor injection
    //   (Modify the existing constructor below)
    // - Create a Counter from the MeterRegistry: name the counter "account.fetch"
    //   with a tag of "type"/"fromCode" key/value pair
    @Autowired
    public AccountAspect(MeterRegistry meterRegistry) {
        this.counter = meterRegistry.counter("account.fetch", "type", "fromAspect");
    }

    @Before("execution(* accounts.web.AccountController.accountSummary(..))")
    public void increment() {
        counter.increment();
    }
}
