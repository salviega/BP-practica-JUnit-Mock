import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DependencyTest {

    @Mock
    private  SubDependency subDependency;
    // simulación
    private Dependency dependency;
    @Before // setear el mock
    public void setupMock() {
        subDependency = mock(SubDependency.class);
        dependency = new Dependency(subDependency);
    }
    @Test
    public void testSubdependency() {
        when(subDependency.getClassName()).thenReturn("hi there 2");
        assertEquals("hi there 2", dependency.getSubdependencyClassName());
    }

    @Test // un Dummy
    public void testDependency() {
        when(dependency.getClassName()).thenReturn("hi there");
        assertEquals("hi there", dependency.getClassName());
    }
    @Test(expected = IllegalArgumentException.class) // lanzar excepciones
    public void testException() {
        when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);
        dependency.getClassName();
    }
    @Test // un Dummy con parámetros
    public void testAddTwo() {
        when(dependency.AddTwo(1)).thenReturn(5);
        assertEquals(5, dependency.AddTwo(1));
        assertEquals(0, dependency.AddTwo(27));
    }
    @Test // cualquier parámetro entero excepto 1 retorna 0, si inyecta u objecto retorna null
    public void testAddTwoAny() {
        when(dependency.AddTwo(anyInt())).thenReturn(0);
        assertEquals(0, dependency.AddTwo(3));
        assertEquals( 0, dependency.AddTwo(80));

    }



}