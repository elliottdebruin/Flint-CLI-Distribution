import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashSet;

import com.github.javaparser.ast.CompilationUnit;

import com.github.s92025592025.flint.FlintConfiguration;
import com.github.s92025592025.flint.LintFailure;
import com.github.s92025592025.flint.rules.CharacterLimitRule;
import com.github.s92025592025.flint.rules.ConsecutiveEmptyLineLimitRule;
import com.github.s92025592025.flint.rules.NoTrailingWhitespaceRule;

public class FlintConfig403 extends FlintConfiguration {

	@Override
	public Collection<LintFailure> runChecks(CompilationUnit astRoot, RandomAccessFile inputFile) throws Exception {
		Collection<LintFailure> result = new HashSet<>();
		result.addAll(CharacterLimitRule.run(inputFile, 80));
		result.addAll(ConsecutiveEmptyLineLimitRule.run(inputFile, 1));
		result.addAll(NoTrailingWhitespaceRule.run(inputFile));
		return result;
	}

}
