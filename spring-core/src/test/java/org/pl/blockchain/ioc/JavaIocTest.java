package org.pl.blockchain.ioc;

import org.pl.blockchain.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class JavaIocTest 
    extends TestCase
{
    private ApplicationContext ctx;

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JavaIocTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( JavaIocTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws InterruptedException 
     */
    public void testConstructIoc() throws InterruptedException
    {
    	ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	Person person=ctx.getBean(Person.class);
        assertNotNull(person);
    }
    public void testScanIoc() throws InterruptedException
    {
    	@SuppressWarnings("resource")
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    	ctx.scan("org.pl.blackchain");
    	ctx.refresh();
    	Person person=ctx.getBean(Person.class);
        assertNotNull(person);
    }
    
    public void testSingleVerify() throws InterruptedException{
    	@SuppressWarnings("resource")
		AnnotationConfigApplicationContext  ctx = new AnnotationConfigApplicationContext();
    	ctx.register(AppConfig.class);
    	ctx.refresh();
    	Person person1=ctx.getBean(Person.class);
    	Thread.sleep(1000L);
    	Person person2=ctx.getBean(Person.class);
        assertEquals(person1, person2);
    }
    
    public void testXmlIoc(){
    	ctx=new ClassPathXmlApplicationContext("beans.xml");
    	Person person=ctx.getBean("defaultPerson",Person.class);
    	assertNotNull(person);
    }
    
    public void testXmlStaticFactoryIoc(){
    	ctx=new ClassPathXmlApplicationContext("beans.xml");
    	Person person=ctx.getBean("staticFactoryPerson",Person.class);
    	assertNotNull(person);
    }
    public void testXmlDynamicFactoryIoc(){
    	ctx=new ClassPathXmlApplicationContext("beans.xml");
    	Person person=ctx.getBean("dynamicFactoryPerson",Person.class);
    	assertNotNull(person);
    }
}
