package com.github.albertosh.uselesslibraryever;

import com.sun.source.util.Trees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Names;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes({
        "*"
})
public class UselessifierProcessor extends AbstractProcessor {

    private Trees trees;
    private TreeMaker make;
    private Names names;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        trees = Trees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment)
                processingEnv).getContext();
        make = TreeMaker.instance(context);
        names = Names.instance(context);
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        roundEnv.getRootElements().stream()
                .filter(element -> element instanceof TypeElement)
                .map(element -> (TypeElement) element)
                .flatMap(type -> type.getEnclosedElements().stream())
                .filter(element -> element instanceof ExecutableElement)
                .map(element -> (ExecutableElement) element)
                .forEach(this::uselessifyMethod);

        return false;
    }

    private void uselessifyMethod(ExecutableElement method) {
        JCTree tree = (JCTree) trees.getTree(method);
        Uselessifier uselessifier = new Uselessifier();
        tree.accept(uselessifier);
    }

    private class Uselessifier extends TreeTranslator {

        @Override
        public void visitMethodDef(JCTree.JCMethodDecl jcMethodDecl) {
            super.visitMethodDef(jcMethodDecl);

            jcMethodDecl.body = buildBody();

            result = jcMethodDecl;
        }

        private JCTree.JCBlock buildBody() {
            JCTree.JCExpression encl = null;
            List<JCTree.JCExpression> typeargs = List.nil();

            JCTree.JCExpression clazz = make.Ident(names.fromString("RuntimeException"));
            JCTree.JCExpression literal = make.Literal("YOU'RE UGLY!!!");
            List<JCTree.JCExpression> args = List.of(literal);
            JCTree.JCClassDecl def = null;
            JCTree.JCExpression exception = make.NewClass(
                    encl,
                    typeargs,
                    clazz,
                    args,
                    def
            );

            JCTree.JCStatement throwExceptionStatement = make.Throw(exception);
            long modifiers = 0L;
            com.sun.tools.javac.util.List statementList = com.sun.tools.javac.util.List.of(throwExceptionStatement);

            return make.Block(modifiers, statementList);
        }

    }

}
