(ns protein-translation)

(def codons-to-protein {"AUG" "Methionine"
                        "UGG" "Tryptophan"
                        "UUU" "Phenylalanine"
                        "UUC" "Phenylalanine"
                        "UUA" "Leucine"
                        "UUG" "Leucine"
                        "UAU" "Tyrosine"
                        "UAC" "Tyrosine"
                        "UGU" "Cysteine"
                        "UGC" "Cysteine"
                        "UCU" "Serine"
                        "UCC" "Serine"
                        "UCA" "Serine"
                        "UCG" "Serine"
                        "UAA" "STOP"
                        "UAG" "STOP"
                        "UGA" "STOP"})

(defn translate-codon [c]
  (codons-to-protein c))

(defn translate-rna
  ([rna] (translate-rna rna []))
  ([rna codons]
   (cond
     (= rna "") codons
     (some (fn [a] (= a (subs rna 0 3))) '("UAA" "UAG" "UGA")) codons
     :else (translate-rna (subs rna 3 (count rna)) (conj codons (translate-codon (subs rna 0 3)))))))