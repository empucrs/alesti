#include <iostream>
#include <exception>
using namespace std;

#include "GenericTree.h"

GenericTree::TreeNode::TreeNode(int e){
	this->value=e;
	this->father=nullptr;
	this->nChild=0;
	this->vetSize=2;
	this->children = new GenericTree::TreeNode *[this->vetSize];
}
void GenericTree::TreeNode::addSubtree(TreeNode * n){
	if(nChild==vetSize)
		grow();
	this->children[this->nChild] = new GenericTree::TreeNode(n->value);
	this->children[this->nChild]->father=this;
	this->nChild++;
}
void GenericTree::TreeNode::grow(){
	GenericTree::TreeNode ** aux = new GenericTree::TreeNode * [this->vetSize*2];
	for(int i=0; i<this->vetSize; i++)
		aux[i]=children[i];
	children=aux;
	this->vetSize*=2;
}
bool GenericTree::TreeNode::removeSubtree(TreeNode * ref){
	int idx=-1;
	for(int i=0; i<this->nChild; i++){
		if(children[i]==ref){
			idx=i;
			break;
		}
	}
	if(idx!=-1){
	  for(int i=idx+1; i<nChild;i++){
	  	children[i-1]=children[i];
	  }
	  children[nChild]=nullptr;
	  nChild--;
	  return true;
	}
	return false;
}
GenericTree::TreeNode * GenericTree::TreeNode::getSubtree(int i){
	if(i>=0 && i<nChild)
		return children[i];
	return nullptr;
}
int GenericTree::TreeNode::getSubtreeSize(){
	return this->nChild;
}
GenericTree::GenericTree(){
	this->root=nullptr;
	nElements=0;
}
GenericTree::TreeNode * GenericTree::searchNode(int value, GenericTree::TreeNode * ref){
  	if(ref!=nullptr){
		if(ref->value==value)
			return ref;
		else{
			GenericTree::TreeNode * aux;		
			for(int i=0; i<ref->getSubtreeSize(); i++){
				aux=searchNode(value, ref->getSubtree(i));
				if(aux!=nullptr)
					return aux;
			}
		}
	}

	return nullptr;
}

bool GenericTree::add(int e, int father){
	if(nElements==0){
		this->root=new GenericTree::TreeNode(e);
		cout << "Incluiu o root: " << this->root->value << endl;
	}
	else{
		GenericTree::TreeNode *aux = searchNode(father, root);
		if(aux==nullptr)
			return false;
		else
			aux->addSubtree(new GenericTree::TreeNode(e));
	}
	nElements++;
	return true;
}
int GenericTree::getRoot(){
	if(this->root != nullptr)
		return this->root->value;
	throw exception();
}
void GenericTree::setRoot(int e){
	if(this->root != nullptr)
		this->root->value=e;
}
int GenericTree::getParent(int e){
	GenericTree::TreeNode * aux;
	aux = searchNode(e, this->root);
	if((aux != nullptr) && (aux->father!=nullptr))
		return aux->father->value;
	else{
		cout << "aux é nulo? " << ((aux==nullptr)?"sim":"não") << endl;
		cout << "pai é nulo? " << ((aux->father==nullptr)?"sim":"não") << endl;
	}
	throw exception();
}
bool GenericTree::removeBranch(int e){
	GenericTree::TreeNode * aux;
	aux = searchNode(e, this->root);
	if(aux!=nullptr){
		if(aux->father!=nullptr)
			aux->father->removeSubtree(aux);			
		else	
			this->root=nullptr;
		removeBranch(aux);
		return true;
	}
	return false;
}
void GenericTree::removeBranch(GenericTree::TreeNode * ref){
	if(ref != nullptr){
		for(int i=0; i<ref->getSubtreeSize(); i++)
			removeBranch(ref->getSubtree(i));
		delete ref;
		nElements--;
	}
}

bool GenericTree::contains(int e){
	return (searchNode(e, this->root)!=nullptr)?true:false;
}
bool GenericTree::isInternal(int e){
	GenericTree::TreeNode * aux = searchNode(e, this->root);
	if(aux==nullptr)
		throw exception();
	return aux->getSubtreeSize()>0?true:false;
}
bool GenericTree::isExternal(int e){
	GenericTree::TreeNode * aux = searchNode(e, this->root);
	if(aux==nullptr)
		throw exception();
	return aux->getSubtreeSize()==0?true:false;
}
bool GenericTree::isRoot(int e){
	if((this->root!=nullptr) && (this->root->value==e))
		return true;
	return false;
}
bool GenericTree::isEmpty(){
	return this->nElements==0;
}
int GenericTree::size(){
	return nElements;
}
void GenericTree::clear(){
	removeBranch(this->root);
	this->root=nullptr;
	nElements=0;
}
int * GenericTree::positionPre(){return nullptr;}
int * GenericTree::positionPos(){return nullptr;}
int * GenericTree::positionWidth(){return nullptr;}
void GenericTree::printTree(){
	printTree(this->root);	
}
void GenericTree::printTree(GenericTree::TreeNode * ref){
	if(ref!=nullptr){
		cout << ref->value << "; ";
		for(int i=0; i<ref->getSubtreeSize(); i++)
			printTree(ref->getSubtree(i));
	}
}