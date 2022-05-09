import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class DependencyVerifyTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Dependency dependency;

    @Test
    public void testSimpleVerify() {
        //nunca se a ejecutado
        verify(dependency, never()).getClassNameUpperCase();
        dependency.getClassNameUpperCase();
        //exactamente una vez
        verify(dependency, times(1)).getClassNameUpperCase();
        dependency.getClassNameUpperCase();
        //como máximo 2 veces
        verify(dependency, atMost(2)).getClassNameUpperCase();
    }

    @Test
    public  void testParameters() {
        dependency.AddTwo(3);
        //una vez con el parámetro 3
        verify(dependency, times(1)).AddTwo(3);
        dependency.AddTwo(4);
        //dos veces con cualquier parámetro
        verify(dependency, times(2)).AddTwo(anyInt());
    }
}
