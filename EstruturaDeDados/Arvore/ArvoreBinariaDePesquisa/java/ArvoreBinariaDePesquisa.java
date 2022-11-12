public class ArvoreBinariaDePesquisa {

    //nodo
    private class BinaryTreeNode{
        public int value;
        public BinaryTreeNode father;
        public BinaryTreeNode left, right;

        public BinaryTreeNode(int e){
            this.value=e;
            father=left=right=null;
        }
    }

    
    //raiz
    BinaryTreeNode root;
    //nElementos
    int nElementos;

    // -- MÉTODOS --
    public ArvoreBinariaDePesquisa(){
        clear();
    }

    public boolean isEmpty(){       
        return nElementos==0;
    }
    public int size(){        
        return nElementos;
    }
    public void clear(){
        // solucao que se apoia em garbage collector
        root=null;
        nElementos=0;
    }
    public int getRoot() throws Exception{
        if(root!=null)        
            return root.value;
        throw new Exception();
    }
    private void add(int e, BinaryTreeNode ref) throws Exception{
        if(ref==null)
            throw new Exception();
        
        if(e <= ref.value){ // tem de ir para a esquerda
            if(ref.left==null){                
                ref.left=new BinaryTreeNode(e);
                ref.left.father=ref;
            }
            else
                add(e, ref.left);
        }
        else{ // tem de ir para a direita
            if(ref.right==null){
                ref.right=new BinaryTreeNode(e);
                ref.right.father=ref;
            }
            else
                add(e, ref.right);
        }        

    }
    public void add(int e) throws Exception{
        if(nElementos==0)
            root=new BinaryTreeNode(e);
        else
            add(e, root);
        nElementos++;
    }
    public boolean remove(int e){
        BinaryTreeNode aux = searchNode(e, root);
        if(aux==null)
            return false;
        
        // SE O NÓ A SER ELIMINADO É UM NÓ FOLHA, ENTÃO A ELIMINAÇÃO É SIMPLES
        if((aux.left==null) && (aux.right==null)){
            if(aux.father!=null){
                if(aux==aux.father.left)
                    aux.father.left=null;
                else
                    aux.father.right=null;
            }
            else
                root=null;
            aux.father=null;
        }
        // SE O NÓ A SER ELIMINADO TEM FILHOS, ENTÃO PRECISO BUSCAR O SUBSTITUTO, MANTENDO A PROPRIEDADE DA ARVORE BINaRIA DE PESQUISA
        else{
            BinaryTreeNode substituto=null;

            // BUSCA NODO A SUBSTITUIR O NODO A SER ELIMINADO            
            if(aux.left!=null){// CASO TENHA SUBaRVORE A ESQUERDA, BUSCO O FILHO MAIS À DIREITA DESTA SUBaRVORE

                // BUSCA NODO MAIS A DIREITA NA SUBARVORE DA ESQUERDA
                substituto=aux.left;
                while(substituto.right!=null)
                    substituto=substituto.right;
                
                // NODO SUBSTITUTO ASSUME A SUBaRVORE DA DIREITA DO NODO A SER REMOVIDO
                //   --> FILHO DA DIREITA DESTE NODO SEMPRE ESTARa LIVRE
                substituto.right=aux.right;
                if(substituto.right!=null)
                    substituto.right.father=substituto;

                // CASO O NODO SUBSTITUTO NÃO SEJA A RAIZ DA SUBARVORE DO NODO A SER REMOVIDO
                if(substituto.father!=aux){ 
                    // (O NODO SUBSTITUTO ASSUME A SUBaRVORE DA ESQUERDA DO NODO A SER REMOVIDO)
                      // 1. NODO SUBSTITUTO LIBERA A SUBaRVORE DA ESQUERDA 
                      //   1.1. A DIREITA DO NODO PAI DO SUBSTITUTO ASSUME A SUBaRVORE DA ESQUERDA DO NODO SUBSTITUTO
                    if(substituto.left!=null)
                        substituto.left.father=substituto.father;
                    substituto.father.right=substituto.left;

                      // 2. NODO SUBSTITUTO ASSUME A SUBaRVORE DA ESQUERDA DO NODO A SER REMOVIDO
                    substituto.left=aux.left;
                    if(substituto.left!=null)
                        substituto.left.father=substituto;
                }
            }
            else{ // CASO NÃO TENHA SUBaRVORE A ESQUERDA, BUSCO NA SUBaRVORE DA DIREITA O NÓ MAIS À ESQUERDA

                // BUSCA NODO MAIS A ESQUERDA NA SUBARVORE DA DIREITA
                substituto=aux.right;
                while(substituto.left!=null)
                    substituto=substituto.left;
                
                // NODO SUBSTITUTO ASSUME A SUBaRVORE DA ESQUERDA DO NODO A SER REMOVIDO
                //   --> FILHO DA ESQUERDA DESTE NODO SEMPRE ESTARa LIVRE
                substituto.left=aux.left;
                if(substituto.left!=null)
                    substituto.left.father=substituto;

                // CASO O NODO SUBSTITUTO NÃO SEJA A RAIZ DA SUBARVORE DO NODO A SER REMOVIDO
                if(substituto.father!=aux){ 
                    // (O NODO SUBSTITUTO ASSUME A SUBaRVORE DA DIREITA DO NODO A SER REMOVIDO)
                      // 1. NODO SUBSTITUTO LIBERA A SUBaRVORE DA DIREITA 
                      //   1.1. A ESQUERDA DO NODO PAI DO SUBSTITUTO ASSUME A SUBaRVORE DA DIREITA DO NODO SUBSTITUTO
                    if(substituto.right!=null)
                        substituto.right.father=substituto.father;
                    substituto.father.left=substituto.right;

                      // 2. NODO SUBSTITUTO ASSUME A SUBaRVORE DA DIREITA DO NODO A SER REMOVIDO
                    substituto.right=aux.right;
                    if(substituto.right!=null)
                        substituto.right.father=substituto;
                }
            }
            // SUBSTITUTO ASSUME O POSTO DE FILHO DO PAI DO NODO A SER REMOVIDO
            substituto.father=aux.father;
            if(aux.father==null)// caso seja o nodo raiz, o pai é o root
                root=substituto;
            else{//caso não seja o nodo raiz, preciso saber se a referência do pai vem da esquerda o da direita
                if(aux.father.left==aux)
                    aux.father.left=substituto;
                else
                    aux.father.right=substituto;
            }
        }
        this.nElementos--;
        return true;
    }
    public int getLeft(int e) throws Exception{
        BinaryTreeNode aux = searchNode(e, root);
        if((aux==null)||(aux.left==null))
            throw new Exception();
        
        return aux.left.value;
    }
    public int getRight(int e) throws Exception{
        BinaryTreeNode aux = searchNode(e, root);
        if((aux==null)||(aux.right==null))
            throw new Exception();
        
        return aux.right.value;
    }
    public int getParent(int e) throws Exception{
        BinaryTreeNode aux = searchNode(e, root);
        if((aux==null)||(aux.father==null))
            throw new Exception();
        
        return aux.father.value;
    }
    private int fillPositonsPre(int [] vet, int pos, BinaryTreeNode ref){
        if(ref!=null){
            // visito a mim mesmo
            vet[pos]=ref.value;
            pos++;
            // visito o filho da esquerda
            pos=fillPositonsPre(vet, pos, ref.left);
            // visito o filho da direita
            pos=fillPositonsPre(vet, pos, ref.right);
        }
        return pos;
    }
    public int[] positionsPre(){
        int [] resultado= new int [this.nElementos];
        if(root!=null)
            fillPositonsPre(resultado, 0, root);
        return resultado;
    }
    private int fillPositonsPos(int [] vet, int pos, BinaryTreeNode ref){
        if(ref!=null){
            // visito o filho da esquerda
            pos=fillPositonsPos(vet, pos, ref.left);
            // visito o filho da direita
            pos=fillPositonsPos(vet, pos, ref.right);
            // visito a mim mesmo
            vet[pos]=ref.value;
            pos++;
        }
        return pos;
    }
    public int[] positionsPos(){
        int [] resultado= new int [nElementos];
        if(root!=null)
            fillPositonsPos(resultado, 0, root);
        return resultado;
    }

    private int fillCentral(int [] vet, int pos, BinaryTreeNode ref){
        if(ref!=null){
            // visito o filho  da esquerda
            pos=fillCentral(vet, pos, ref.left);
            // visito a mim mesmo
            vet[pos]=ref.value;            
            pos++;
            // visito o filho da direita
            pos = fillCentral(vet, pos, ref.right);
        }
        return pos;
    }
    public int[] positionsCentral(){
        // tem de revisitar para implementar        
        if(nElementos==0)
            return null;

        int [] resultado = new int[nElementos];
        fillCentral(resultado, 0, root);

        return resultado;
    }

    public int[] positionsWidth(){
        if(root==null)
            return null;        

        int [] resultado = new int[this.nElementos];
        int nroResultados=0;
        BinaryTreeNode [] aVisitar = new BinaryTreeNode[this.nElementos];
        int buscaIdx=0;
        aVisitar[buscaIdx++]=root;
        int posAtual=0;
        while(nroResultados<this.nElementos){
            //ADICIONO UM NOVO ELEMENTO NA LISTA DE RESULTADOS
            resultado[nroResultados++]=aVisitar[posAtual].value;

            // CARREGO O PRÓXIMO NÍVEL, A PARTIR DO NODO ATUAL
            // SE HOUVER NODO A ESQUERDA, ADICIONO NA LISTA DE NODOS A SEREM VISITADOS
            if(aVisitar[posAtual].left!=null)
                aVisitar[buscaIdx++]=aVisitar[posAtual].left;

            // SE HOUVER NODO À DIREITA, ADICIONO NA LISTA DE NODOS A SEREM VISITADOS
            if(aVisitar[posAtual].right!=null)
                aVisitar[buscaIdx++]=aVisitar[posAtual].right;                            

            // INCREMENTA A POSICAO A SER VISITADA NA PROXIMA RODADA
            posAtual++;
        }
        return resultado;
    }
    private BinaryTreeNode searchNode(int e, BinaryTreeNode ref){
        if(ref==null) return null;

        if((ref!=null) &&(e==ref.value))
            return ref;        

        BinaryTreeNode aux=null;
        aux=searchNode(e, ref.left);
        if(aux!=null) return aux;

        aux=searchNode(e, ref.right);
        if(aux!=null) return aux;

        return null;
    }
    public int level(int e){        
        BinaryTreeNode aux = searchNode(e, root);
        int nodeLevel=-1;
        while(aux!=null){
            nodeLevel++;
            aux=aux.father;
        }
        return nodeLevel;        
    }
    public boolean contains(int e){        
        return searchNode(e, root)!=null;
    }
    public int height(){
        if(this.nElementos==0)
            return 0;
        int [] listOfNodes = positionsWidth();
        return (level(listOfNodes[listOfNodes.length-1])+1);
    }
    boolean isInternal(Integer e) throws Exception{
        BinaryTreeNode aux = searchNode(e, root);
        if(aux==null)
            throw new Exception();
        
        return ((aux.left!=null)||(aux.right!=null));
    }
    boolean isExternal(Integer e) throws Exception{
        BinaryTreeNode aux = searchNode(e, root);
        if(aux==null)
            throw new Exception();        
        return ((aux.left==null)&&(aux.right==null));
    }
    String graphvizDiagram(){

        String resultado="Use o graphviz para visualizar a árvore: link para graphviz online -> https://dreampuf.github.io/GraphvizOnline\n";
        resultado+="digraph GViz{\n";

        if(root==null)
            return null;        

        int nroResultados=0;
        BinaryTreeNode [] aVisitar = new BinaryTreeNode[this.nElementos];
        int buscaIdx=0;
        aVisitar[buscaIdx++]=root;
        int posAtual=0;
        int nNulls=0;

        while(nroResultados<this.nElementos){
            resultado += "  " + aVisitar[posAtual].value;
            String termos = "";

            if(aVisitar[posAtual].left!=null){
                termos += " "+aVisitar[posAtual].left.value+" ";
                aVisitar[buscaIdx++]=aVisitar[posAtual].left;
            }
            else{
                termos += " null"+ (nNulls++) + " ";
            }
            if(aVisitar[posAtual].right!=null){
                termos += " "+aVisitar[posAtual].right.value+" ";
                aVisitar[buscaIdx++]=aVisitar[posAtual].right;
            }
            else{
                termos += " null"+ (nNulls++) + " ";
            }

            if(termos.length()>0)
                resultado += " -> {" + termos + " }";

            resultado += "\n";

            // INCREMENTA A POSICAO A SER VISITADA NA PROXIMA RODADA
            nroResultados++;
            posAtual++;
        }

        for(int i=0; i< nNulls; i++){
            resultado+= "  null"+i+" [shape=point]\n";
        }

        resultado+="}\n";
        return resultado;
    }
}
