package test;

import main.modeling102.service.IdeaService;
import main.modeling102.service.impl.IdeaServiceSerializerImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

/**
 * @author maruf
 * @since 10/26/17
 */
public class IdeaServiceTest extends Arquillian {
    IdeaService ideaService = IdeaServiceSerializerImpl.getInstance();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(IdeaService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
